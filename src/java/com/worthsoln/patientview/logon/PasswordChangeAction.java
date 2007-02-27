package com.worthsoln.patientview.logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logging.AddLog;

public class PasswordChangeAction extends Action {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = request.getUserPrincipal().getName();
        User user = (User) HibernateUtil.getPersistentObject(User.class, username);
        String suppliedOldPassword = BeanUtils.getProperty(form, "oldpassword");
        String actualOldPassword = user.getPassword();

        if (suppliedOldPassword.equals(actualOldPassword)) {
            user.setPassword(BeanUtils.getProperty(form, "newpassword"));
            user.setFirstlogon(false);
            HibernateUtil.saveOrUpdateWithTransaction(user);

            AddLog.addLog(user.getUsername(), AddLog.PASSWORD_CHANGE, user.getUsername(), "");
            return mapping.findForward("success");
        } else {
            request.setAttribute("error", "incorrect current password");

            return mapping.findForward("input");
        }
    }
}
