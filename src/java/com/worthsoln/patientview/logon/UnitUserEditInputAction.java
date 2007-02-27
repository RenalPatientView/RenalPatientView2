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

public class UnitUserEditInputAction extends Action {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        User user = (User) HibernateUtil.getPersistentObject(User.class, username);

        request.getSession().setAttribute("unitUser", user);

        return LogonUtils.logonChecks(mapping, request);
    }
}
