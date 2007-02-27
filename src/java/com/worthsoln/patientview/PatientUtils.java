package com.worthsoln.patientview;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import com.worthsoln.database.DatabaseDAO;

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

        return retrievePatient(nhsno, dao);
    }

    static Patient retrievePatient(String nhsno, DatabaseDAO dao) {
        PatientDao patientDao = new PatientDao(new Patient(nhsno));
        Patient patient = (Patient) dao.retrieveItem(patientDao);

        return patient;
    }

    /*
        static String retrieveNhsNo(HttpServletRequest request) {
            String nhsno = null;

            try {
                String username = request.getUserPrincipal().getName();
                Session session = HibernateUtil.currentSession();
                Transaction tx = session.beginTransaction();
                User user = (User) session.get(User.class, username);

                tx.commit();
                HibernateUtil.closeSession();

                nhsno = user.getNhsno();
            } catch (HibernateException e) {
                e.printStackTrace();
            }

            return nhsno;
        }
    */
}
