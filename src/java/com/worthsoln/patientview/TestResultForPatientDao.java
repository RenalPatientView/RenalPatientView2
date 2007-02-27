package com.worthsoln.patientview;

import java.util.ArrayList;
import java.util.Collection;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import com.worthsoln.database.DatabaseQuery;

public class TestResultForPatientDao extends TestResultDao {

    private String nhsno;
    private int panel = 1;

    public TestResultForPatientDao(String nhsno) {
        this.nhsno = nhsno;
    }

    public TestResultForPatientDao(String nhsno, Panel panel) {
        this.nhsno = nhsno;
        if (panel != null) {
            this.panel = panel.getPanel();
        }
    }

    public Collection getRetrieveListWhereClauseParameters() {
        ArrayList params = new ArrayList();
        params.add(nhsno);
        params.add(new Integer(panel));
        return params;
    }

    public DatabaseQuery getRetrieveListQuery() {
        ArrayList parameters = new ArrayList();
        parameters.addAll(getRetrieveListWhereClauseParameters());
        String sql = "SELECT testresult.* FROM testresult, result_heading WHERE testresult.nhsno = ? "
                + "AND testresult.testcode = result_heading.headingcode AND result_heading.panel = ?";
        ResultSetHandler rsHandler = new BeanListHandler(getTableMapper());
        return new DatabaseQuery(sql, parameters.toArray(), rsHandler);
    }
}
