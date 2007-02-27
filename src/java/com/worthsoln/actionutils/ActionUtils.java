package com.worthsoln.actionutils;

import java.lang.reflect.InvocationTargetException;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionForm;
import org.apache.commons.beanutils.BeanUtils;

public class ActionUtils {

    public static void setUpNavLink(String parameter, HttpServletRequest request) {
        if ((parameter != null) && !("".equals(parameter))) {
            request.setAttribute("currentNav", parameter);
        }
    }

    public static  String retrieveStringPropertyValue(String propertyName, ActionForm form, HttpServletRequest request)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String nhsno = BeanUtils.getProperty(form, propertyName);
        if (nhsno == null) {
            nhsno = (String) request.getAttribute(propertyName);
        }
        return nhsno;
    }
}
