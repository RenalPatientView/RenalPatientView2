package com.worthsoln.patientview.letter;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logon.LogonUtils;

public class LetterDetailAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        int letterId = Integer.parseInt(request.getParameter("letterId"));
        Letter letter = getLetterForPatient(letterId);
        boolean permissionToReadLetter = verifyPermissionToReadLetter(request, letter);
        if (permissionToReadLetter) {
            request.setAttribute("letter", letter);
            return LogonUtils.logonChecks(mapping, request);
        } else {
            return LogonUtils.logonChecks(mapping, request, "nopermission");
        }
    }

    private boolean verifyPermissionToReadLetter(HttpServletRequest request, Letter letter) {
        boolean permissionToReadLetter = false;
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            String username = userPrincipal.getName();
            User user = (User) HibernateUtil.getPersistentObject(User.class, username);
            if (user.getRole().equalsIgnoreCase("patient") && (user.getNhsno().equals(letter.getNhsno()))) {
                permissionToReadLetter = true;
            } else if (user.getRole().equalsIgnoreCase("unitadmin") &&
                    (user.getUnitcode().equalsIgnoreCase(letter.getUnitcode()))) {
                permissionToReadLetter = true;
            } else if (user.getRole().equalsIgnoreCase("unitstaff") &&
                    (user.getUnitcode().equalsIgnoreCase(letter.getUnitcode()))) {
                permissionToReadLetter = true;
            } else if (user.getRole().equalsIgnoreCase("superadmin")) {
                permissionToReadLetter = true;
            }
        }
        return permissionToReadLetter;
    }

    private Letter getLetterForPatient(int letterId) throws HibernateException {
        Session session = HibernateUtil.currentSession();
        Letter letter = (Letter) session.get(Letter.class, new Integer(letterId));
        HibernateUtil.closeSession();
        return letter;
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "letter";
    }
}
