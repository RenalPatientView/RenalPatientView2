package com.worthsoln.patientview.unit;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.UserDao;

public class UnitUtils {

    public static void putRelevantUnitsInRequest(HttpServletRequest request) throws HibernateException {
        String unitcode = usersUnitCode(request);
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List items;
        if ("all".equals(unitcode)) {
            items = session.find("from " + Unit.class.getName());
        } else {
            items = session.find("from " + Unit.class.getName() + " as unit where unit.unitcode = ?",
                    unitcode, Hibernate.STRING);
        }
        tx.commit();
        HibernateUtil.closeSession();
        request.getSession().setAttribute("units", items);
    }

    public static String usersUnitCode(HttpServletRequest request) {
        String unitcode = "all";
        User user = (User) HibernateUtil.getPersistentObject(User.class, request.getUserPrincipal().getName());
        if (!user.getRole().equals("superadmin")) {
            unitcode = user.getUnitcode();
        }
        return unitcode;
    }

    public static String retrieveUnitcode(HttpServletRequest request, DatabaseDAO dao) {
        String unitcode = null;
        if (request.isUserInRole("patient")) {
            Principal principal = request.getUserPrincipal();
            String username = principal.getName();
            User user = (User) dao.retrieveItem(new UserDao(new User(username)));
            unitcode = user.getUnitcode();
        } else {
            unitcode = (String) request.getSession().getAttribute("patientBeingViewedUnitcode");
        }
        return unitcode;
    }

}
