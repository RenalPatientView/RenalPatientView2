package com.worthsoln.patientview;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.patientview.unit.UnitUtils;

public class PatientUtils {

    static String retrieveNhsNo(HttpServletRequest request, DatabaseDAO dao) {
        String nhsno = null;
        if (request.isUserInRole("patient")) {
            Principal principal = request.getUserPrincipal();
            String username = principal.getName();
            User user = (User) dao.retrieveItem(new UserDao(new User(username)));
            nhsno = user.getNhsno();
        } else {
            nhsno = (String) request.getSession().getAttribute("patientBeingViewedNhsNo");
        }
        return nhsno;
    }

    public static Patient retrievePatient(HttpServletRequest request, DatabaseDAO dao) {
        String nhsno = PatientUtils.retrieveNhsNo(request, dao);
        String unitcode = UnitUtils.retrieveUnitcode(request, dao);
        return retrievePatient(nhsno, unitcode, dao);
    }

    static Patient retrievePatient(String nhsno, String unitcode, DatabaseDAO dao) {
        PatientDao patientDao = new PatientDao(new Patient(nhsno, unitcode));
        Patient patient = (Patient) dao.retrieveItem(patientDao);
        return patient;
    }
}
