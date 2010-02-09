package com.worthsoln.patientview.logon;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logging.AddLog;
import com.worthsoln.patientview.unit.UnitUtils;

public class UnitAdminAddAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        String username = BeanUtils.getProperty(form, "username");
        String password = LogonUtils.generateNewPassword();
        String name = BeanUtils.getProperty(form, "name");
        String email = BeanUtils.getProperty(form, "email");
        String unitcode = BeanUtils.getProperty(form, "unitcode");
        String role = BeanUtils.getProperty(form, "role");
        UnitAdmin unitAdmin = new UnitAdmin(username, password, name, email, unitcode, role, true);
        DatabaseDAO dao = getDao(request);
        User existingAdminWithSameUsername = (User) HibernateUtil.getPersistentObject(User.class, username);
        String mappingToFind;
        if (existingAdminWithSameUsername != null) {
            request.setAttribute(LogonUtils.USER_ALREADY_EXISTS, username);
            unitAdmin.setUsername("");
            UnitUtils.putRelevantUnitsInRequest(request);
            mappingToFind = "input";
        } else {
            UnitAdmin hashedUnitAdmin = (UnitAdmin) unitAdmin.clone();
            hashedUnitAdmin.setPassword(LogonUtils.hashPassword(hashedUnitAdmin.getPassword()));
            dao.insertItem(new LogonDao(hashedUnitAdmin));
            AddLog.addLog(request.getUserPrincipal().getName(), AddLog.ADMIN_ADD, unitAdmin.getUsername(), "",
                    unitAdmin.getUnitcode(), "");
            mappingToFind = "success";
        }
        request.setAttribute("adminuser", unitAdmin);
        return mapping.findForward(mappingToFind);
    }

    public String getIdentifier() {
        return null;
    }

    public String getDatabaseName() {
        return "patientview";
    }
}
