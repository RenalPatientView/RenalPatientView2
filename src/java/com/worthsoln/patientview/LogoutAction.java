package com.worthsoln.patientview;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForm;
import com.worthsoln.actionutils.ActionUtils;

public class LogoutAction extends Action {

    public ActionForward execute(
        ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        request.getSession().invalidate();
        ActionUtils.setUpNavLink(mapping.getParameter(), request);
        response.sendRedirect("index.do");

        return null;
    }
}
