package com.worthsoln.patientview.diagnosis;

import java.util.List;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import com.worthsoln.HibernateUtil;

public class DiagnosisUtils {

    public static List getOtherDiagnoses(String nhsno) throws HibernateException {
        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();
        List diagnoses = session.find("from " + Diagnosis.class.getName()
                + " as diagnosis where diagnosis.nhsno = ? order by diagnosis.displayorder asc",
                nhsno, Hibernate.STRING);
        tx.commit();
        HibernateUtil.closeSession();
        return diagnoses;
    }
}
