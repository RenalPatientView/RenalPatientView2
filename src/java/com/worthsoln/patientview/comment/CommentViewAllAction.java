package com.worthsoln.patientview.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.type.Type;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.news.News;
import com.worthsoln.patientview.news.NewsUtils;
import com.worthsoln.patientview.letter.Letter;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.PatientUtils;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.resultheading.ResultHeading;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.user.UserUtils;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.database.DatabaseDAO;

import java.util.List;
import java.util.ArrayList;
import java.security.Principal;

public class CommentViewAllAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);
        String nhsno = patient.getNhsno();

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List<Comment> comments = session.find("from " + Comment.class.getName() + " as comment where comment.nhsno = ? " ,
                             new Object[] {nhsno}, new Type[] {Hibernate.STRING});
        tx.commit();
        HibernateUtil.closeSession();

        if (verifyPermissionToReadComment(request, nhsno)) {
            request.setAttribute("comments", comments);
            return LogonUtils.logonChecks(mapping, request);
        } else {
            return LogonUtils.logonChecks(mapping, request, "nopermission");
        }
    }

    private boolean verifyPermissionToReadComment(HttpServletRequest request, String nhsno) throws Exception {
        boolean permissionToReadComment = false;
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            String username = userPrincipal.getName();
            User user = (User) HibernateUtil.getPersistentObject(User.class, username);
            DatabaseDAO dao = getDao(request);
            Patient patient = PatientUtils.retrievePatient(request, dao);
            if (user.getRole().equalsIgnoreCase("patient") && (user.getNhsno().equals(nhsno))) {
                permissionToReadComment = true;
            } else if (user.getRole().equalsIgnoreCase("unitadmin") &&
                    (user.getUnitcode().equalsIgnoreCase(patient.getCentreCode()))) {
                permissionToReadComment = true;
            } else if (user.getRole().equalsIgnoreCase("unitstaff") &&
                    (user.getUnitcode().equalsIgnoreCase(patient.getCentreCode()))) {
                permissionToReadComment = true;
            } else if (user.getRole().equalsIgnoreCase("superadmin")) {
                permissionToReadComment = true;
            }
        }
        return permissionToReadComment;
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "news";
    }
}