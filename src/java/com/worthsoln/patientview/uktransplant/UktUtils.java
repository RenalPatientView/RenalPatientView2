package com.worthsoln.patientview.uktransplant;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.worthsoln.database.DatabaseDAO;

public class UktUtils {

    public static void addUktStatusToRequest(String nhsno, DatabaseDAO dao, HttpServletRequest request) {
        UktStatusForPatientDao uktStatusDao = new UktStatusForPatientDao(nhsno);
        List statusList = (List) dao.retrieveItem(uktStatusDao);
        UktStatusForPatient status = null;
        if (statusList.size() != 0) {
            status = (UktStatusForPatient) statusList.get(0);
        }
        request.setAttribute("uktstatus", status);
    }
}
