package com.worthsoln.patientview;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.worthsoln.database.DatabaseQuery;

public class TestResultForPatientDataOutDao extends TestResultDao {

    private String nhsno;
    private String patientEnteredUnit = "PATIENT";

    public TestResultForPatientDataOutDao(String nhsno) {
        this.nhsno = nhsno;
    }

    public Collection getRetrieveListWhereClauseParameters() {
        ArrayList params = new ArrayList();
        params.add(nhsno);
        params.add(patientEnteredUnit);
        return params;
    }

    public DatabaseQuery getRetrieveListQuery() {
        ArrayList parameters = new ArrayList();
        parameters.addAll(getRetrieveListWhereClauseParameters());
        String sql = "SELECT testresult.* FROM testresult WHERE testresult.nhsno = ? AND testresult.unitcode = ? " +
                " ORDER BY testcode, datestamp";
        ResultSetHandler rsHandler = new BeanListHandler(getTableMapper());
        return new DatabaseQuery(sql, parameters.toArray(), rsHandler);
    }

    public Class getTableMapper() {
        return TestResult.class;
    }
}