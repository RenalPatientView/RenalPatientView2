package com.worthsoln.patientview.notification;

import com.amazonaws.auth.BasicAWSCredentials;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.EmailUtils;
import com.worthsoln.patientview.TestResult;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.logon.UserMapping;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Query;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

import javax.servlet.ServletContext;


import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: jeff
 * Date: 27-May-2012
 * Time: 10:36:17
 * To change this template use File | Settings | File Templates.
 */
public class Notifier {

    private static final String FROM = "renalpatientview@doismellburning.co.uk";
    private static final String BODY = "Please log into http://www.renalpatientview.org/ to view your test results.";
    private static final String SUBJECT = "You have new test results available on Renal PatientView";
    private ServletContext servletContext;
    public Notifier(ServletContext servletContext)
    {
        this.servletContext = servletContext;
    }

    public void notifyTestResults(Collection testResults)
    {
        List<UserMapping> mappings = userMappingsFromResults(testResults);
        List<User> usersToNotify = usersFromUserMappings(mappings);
        if (usersToNotify.isEmpty()) {
            System.out.println("No users to be notified for the new test results");
        } else {
            notifyUsersOfResults(new HashSet(usersToNotify));
        }
    }

    private List<UserMapping> userMappingsFromResults(Collection results) {
        // "Optimisation"
        Set<String> nhsNumberSet = new HashSet<String>();
        for (Object resultObj : results) {
            TestResult result = (TestResult) resultObj;
            nhsNumberSet.add(result.getNhsno());
        }

        List<UserMapping> userMappings;
        try {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from " + UserMapping.class.getName() + " as usermapping where usermapping.nhsno in (:nhsnumbers) and usermapping.unitcode = 'PATIENT'");
            query.setParameterList("nhsnumbers", new ArrayList(nhsNumberSet));
            userMappings = query.list();
            tx.commit();
            HibernateUtil.closeSession();
        } catch (HibernateException e) {
            System.out.println("Error getting user mappings: " + e);
            return null;
        }

        return userMappings;
    }

    private List<User> usersFromUserMappings(List<UserMapping> userMappings) {
        Set<String> usernameSet = new HashSet<String>();
        for (UserMapping userMapping : userMappings) {
            usernameSet.add(userMapping.getUsername());
        }

        List<User> users;
        try {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            Query query = session.createQuery("from " + User.class.getName() + " as user where user.username in (:usernames)");
            query.setParameterList("usernames", new ArrayList(usernameSet));
            users = query.list();
            tx.commit();
            HibernateUtil.closeSession();
        } catch (HibernateException e) {
            System.out.println("Error getting user mappings: " + e);
            return null;
        }

        return users;
    }

    private void notifyUsersOfResults(Set<User> usersToBeNotified) {
        System.out.println("Notifying users of results: " + usersToBeNotified);
        for (User user : usersToBeNotified) {
            System.out.println("Notifying user: " + user.getEmail());
            EmailUtils.sendEmail(servletContext, FROM, user.getEmail(), SUBJECT, BODY);
        }
        System.out.println("Notified users of results: " + usersToBeNotified);
    }
}
