package com.worthsoln.patientview.unit;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logon.LogonUtils;

public class UnitsDisplayAction extends DatabaseAction {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        User user = (User) HibernateUtil.getPersistentObject(User.class, request.getUserPrincipal().getName());
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List items;

        if (user.getRole().equals("superadmin")) {
            items = session.find("from " + Unit.class.getName());
        } else {
            items = session.find("from " + Unit.class.getName() + " as unit where unit.unitcode = ?",
                                 user.getUnitcode(), Hibernate.STRING);
        }

        tx.commit();
        HibernateUtil.closeSession();
        request.getSession().setAttribute("units", items);

        return LogonUtils.logonChecks(mapping, request);
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "unit";
    }
}
