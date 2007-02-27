package com.worthsoln.patientview.uktransplant;

import java.util.ArrayList;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.worthsoln.database.DatabaseQuery;
import com.worthsoln.patientview.PatientDao;

public class UktPatientDao extends PatientDao {

    public DatabaseQuery getRetrieveListQuery() {
        ArrayList parameters = new ArrayList();
        parameters.addAll(getRetrieveListWhereClauseParameters());
        String sql = "SELECT DISTINCT patient.* FROM patient, user "
                + "WHERE patient.nhsno REGEXP '^[0-9]{10}$' "
                + "AND patient.nhsno = user.nhsno "
                + "AND user.username NOT LIKE '%-GP' "
                + "AND user.dummypatient = 0";
        ResultSetHandler rsHandler = new BeanListHandler(getTableMapper());
        return new DatabaseQuery(sql, parameters.toArray(), rsHandler);
    }
}
