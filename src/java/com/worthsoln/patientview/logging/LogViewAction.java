package com.worthsoln.patientview.logging;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.Criteria;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.expression.Expression;
import net.sf.hibernate.expression.Order;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.TestResultDao;
import com.worthsoln.patientview.logon.LogonUtils;

public class LogViewAction extends Action {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        Calendar startdate = determineStartDate(form);
        Calendar enddate = determineEndDate(form);
        String nhsno = BeanUtils.getProperty(form, "nhsno");
        String user = BeanUtils.getProperty(form, "user");
        String actor = BeanUtils.getProperty(form, "actor");
        String action = BeanUtils.getProperty(form, "action");
        List log = getLogEntries(nhsno, user, actor, action, startdate, enddate);
        request.setAttribute("log", log);
        LoggingUtils.defaultDatesInForm(form, startdate, enddate);
        return LogonUtils.logonChecks(mapping, request);
    }

    private Calendar determineStartDate(ActionForm form)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String startDateString = BeanUtils.getProperty(form, "startdate");
        Calendar startdate;
        if ((startDateString == null) || ("".equals(startDateString))) {
            startdate = LoggingUtils.getDefaultStartDateForLogQuery();
        } else {
            startdate = getSensibleDate(startDateString, "00:00");
        }
        return startdate;
    }

    private Calendar determineEndDate(ActionForm form)
            throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
        String startDateString = BeanUtils.getProperty(form, "enddate");
        Calendar startdate;
        if ((startDateString == null) || ("".equals(startDateString))) {
            startdate = LoggingUtils.getDefaultEndDateForLogQuery();
        } else {
            startdate = getSensibleDate(startDateString, "23:59");
        }
        return startdate;
    }

    private static List getLogEntries(String nhsno, String user, String actor, String action, Calendar startdate,
                                      Calendar enddate)
            throws HibernateException {
        List logEntries = new ArrayList();
        if (!((nhsno.equals("")) && (user.equals("")) && (actor.equals("")) && (action.equals("")))) {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            Criteria criteria = session.createCriteria(LogEntry.class);
            criteria.add(Expression.between("date", startdate, enddate));
            criteria.add(Expression.like("nhsno", "%" + nhsno + "%"));
            criteria.add(Expression.like("user", "%" + user + "%"));
            criteria.add(Expression.like("actor", "%" + actor + "%"));
            criteria.add(Expression.like("action", "%" + action + "%"));
            criteria.addOrder(Order.asc("id"));
            logEntries = criteria.list();
            tx.commit();
            HibernateUtil.closeSession();
        }
        return logEntries;
    }

    private static Calendar getSensibleDate(String dateString, String timeString) {
        Calendar cal = Calendar.getInstance();
        if (dateString.length() >= 10) {
            try {
                cal = TestResultDao.createTimestamp(dateString + " " + timeString);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return cal;
    }
}
