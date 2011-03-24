package com.worthsoln.patientview.aboutme;

import com.worthsoln.HibernateUtil;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;

public class AboutmeUtils {

    static Aboutme fetchAboutmeForPatient(String nhsno) throws HibernateException {

        Session session = HibernateUtil.currentSession();
        Transaction tx = session.beginTransaction();

        Aboutme aboutme = (Aboutme) session.createQuery("from " + Aboutme.class.getName() + " as aboutme where aboutme.nhsno = :nhsno ")
                .setString("nhsno", nhsno)
                .uniqueResult();

        tx.commit();
        HibernateUtil.closeSession();
        return aboutme;
    }
}
