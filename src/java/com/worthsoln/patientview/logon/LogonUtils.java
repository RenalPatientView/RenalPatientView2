package com.worthsoln.patientview.logon;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.Ostermiller.util.RandPass;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logging.AddLog;

public class LogonUtils {

    public static final String USER_ALREADY_EXISTS = "userAlreadyExists";
    public static final String NHSNO_ALREADY_EXISTS = "nhsnoAlreadyExists";

    public static ActionForward logonChecks(ActionMapping mapping, HttpServletRequest request,
                                            String defaultForward) {
        String resultForward = defaultForward;
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            String username = userPrincipal.getName();
            User user = (User) HibernateUtil.getPersistentObject(User.class, username);
            if (user.isFirstlogon()) {
                if (user.getRole().equalsIgnoreCase("patient")) {
                    resultForward = "patientPasswordChangeInput";
                } else {
                    resultForward = "controlPasswordChangeInput";
                }
                request.setAttribute("firstLogon", "true");
            }
        }
        recordLogon(request);
        return mapping.findForward(resultForward);
    }

    private static void recordLogon(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String logonRecorded = (String) session.getAttribute("logonRecorded");
        if (logonRecorded == null && request.getUserPrincipal() != null) {
            AddLog.addLog(request.getUserPrincipal().getName(), AddLog.LOGGED_ON, request.getUserPrincipal().getName(),
                    "", "");
            session.setAttribute("logonRecorded", "true");
        }
    }

    public static ActionForward logonChecks(ActionMapping mapping, HttpServletRequest request) {
        return logonChecks(mapping, request, "success");
    }

    public static String generateNewPassword() {
        return new RandPass(RandPass.NONCONFUSING_ALPHABET).getPass(8);
    }

    public static String displayRole(String role) {
        String displayRole = "";
        if ("unitadmin".equals(role)) {
            displayRole = "Unit Admin";
        } else if ("unitstaff".equals(role)) {
            displayRole = "Unit Staff";
        } else if ("patient".equals(role)) {
            displayRole = "Patient";
        } else if ("superadmin".equals(role)) {
            displayRole = "Super Admin";
        } else {
            displayRole = "Role Unknown";
        }
        return displayRole;
    }
}
