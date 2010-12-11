package com.worthsoln.patientview.comment;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.news.News;
import com.worthsoln.patientview.news.NewsUtils;
import com.worthsoln.patientview.letter.Letter;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.PatientUtils;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.logon.LogonUtils;
import com.worthsoln.patientview.user.UserUtils;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.database.DatabaseDAO;

import java.util.List;
import java.util.ArrayList;
import java.security.Principal;

public class CommentViewAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response) throws Exception {
        int commentId = Integer.parseInt(request.getParameter("commentId"));
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        Comment comment = (Comment) session.get(Comment.class, commentId);
        tx.commit();
        HibernateUtil.closeSession();

        if (verifyPermissionToReadComment(request, comment)) {
        List<Comment> comments = new ArrayList<Comment>();

        comments.add(comment);

        request.setAttribute("comments", comments);
            return LogonUtils.logonChecks(mapping, request);
        } else {
            return LogonUtils.logonChecks(mapping, request, "nopermission");
        }
    }

    private boolean verifyPermissionToReadComment(HttpServletRequest request, Comment comment) throws Exception {
        boolean permissionToReadComment = false;
        Principal userPrincipal = request.getUserPrincipal();
        if (userPrincipal != null) {
            String username = userPrincipal.getName();
            User user = (User) HibernateUtil.getPersistentObject(User.class, username);
            String nhsno = comment.getNhsno();
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
