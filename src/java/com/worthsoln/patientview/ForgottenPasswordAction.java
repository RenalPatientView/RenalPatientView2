package com.worthsoln.patientview;

import com.worthsoln.HibernateUtil;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.logon.LogonUtils;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgottenPasswordAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        if (username != null && username.trim().length() > 0) {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();

            // From the username get the number of failed logins and display the locked out message if that's the case
            Criteria criteria = session.createCriteria(User.class);
            criteria.add(Expression.like("username", username));
            User user = (User) criteria.uniqueResult();

            request.setAttribute("foundUser", user != null);
            if (user != null) {
                if (user.getEmail() != null && user.getEmail().trim().length() > 0) {
                    String password = LogonUtils.generateNewPassword();
                    user.setPassword(LogonUtils.hashPassword(password));

                    // Email password
                    String message = "Hello User,\n" +
                            "\n" +
                            "Your password has been reset, your new password is\n" +
                            password + "\n" +
                            "\n" +
                            "Renal Patient View";
                    EmailUtils.sendEmail(request.getSession().getServletContext(), user.getEmail(),
                            "Renal Patient View - Your password has been reset", message);
                    session.save(user);
                } else {
                    request.setAttribute("nullEmail", true);
                }
            }
            tx.commit();
            HibernateUtil.closeSession();
        } else {
            request.setAttribute("nullUser", true);
        }
        return mapping.findForward("success");
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "user";
    }

}