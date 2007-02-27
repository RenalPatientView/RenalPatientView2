package com.worthsoln.patientview.letter;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.worthsoln.HibernateUtil;
import com.worthsoln.database.DatabaseDAO;
import com.worthsoln.database.action.DatabaseAction;
import com.worthsoln.patientview.Patient;
import com.worthsoln.patientview.PatientUtils;
import com.worthsoln.patientview.logon.LogonUtils;

public class LetterDisplayAction extends DatabaseAction {

    public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
                                 HttpServletResponse response)
            throws Exception {
        DatabaseDAO dao = getDao(request);
        Patient patient = PatientUtils.retrievePatient(request, dao);
        List letters = getLettersForPatient(patient);
        request.setAttribute("letters", letters);
        request.setAttribute("patient", patient);
        return LogonUtils.logonChecks(mapping, request);
    }

    private List getLettersForPatient(Patient patient) throws HibernateException {
        List letters = new ArrayList();
        if (patient != null) {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            letters = session.find("from " + Letter.class.getName()
                    + " as letter where letter.nhsno = ? order by letter.date desc",
                    patient.getNhsno(), Hibernate.STRING);
            tx.commit();
            HibernateUtil.closeSession();
        }
        return letters;
    }

    public String getDatabaseName() {
        return "patientview";
    }

    public String getIdentifier() {
        return "letter";
    }
}
