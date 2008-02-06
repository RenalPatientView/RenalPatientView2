package com.worthsoln.patientview.news;

import java.security.Principal;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import net.sf.hibernate.Hibernate;
import net.sf.hibernate.HibernateException;
import net.sf.hibernate.Session;
import net.sf.hibernate.Transaction;
import net.sf.hibernate.type.Type;
import com.worthsoln.HibernateUtil;
import com.worthsoln.patientview.User;
import com.worthsoln.patientview.unit.UnitUtils;

public class NewsUtils {

    public static void putAppropriateNewsForViewingInRequest(HttpServletRequest request) throws HibernateException {
        String hsql = "";
        Object[] params = new Object[]{};
        Type[] types = new Type[]{};
        Principal principal = request.getUserPrincipal();
        if (principal == null) {
            hsql = "from " + News.class.getName() + " as news where news.everyone = ?";
            params = new Object[]{1};
            types = new Type[]{Hibernate.INTEGER};
        } else {
            User user = (User) HibernateUtil.getPersistentObject(User.class, request.getUserPrincipal().getName());
            String userType = user.getRole();
            if ("superadmin".equals(userType)) {
                hsql = "from " + News.class.getName() + " as news";
            } else if ("unitadmin".equals(userType) || "unitstaff".equals(userType)) {
                String unitcode = UnitUtils.usersUnitCode(request);
                hsql = "from " + News.class.getName() +
                        " as news where ((news.unitcode = ? or news.unitcode = ?) and (news.admin = ? or news.patient = ?)) " +
                        " or news.everyone = ?";
                params = new Object[]{unitcode, "all", 1, 1, 1};
                types = new Type[]{Hibernate.STRING, Hibernate.STRING, Hibernate.INTEGER, Hibernate.INTEGER,
                        Hibernate.INTEGER};
            } else if ("patient".equals(userType)) {
                String unitcode = UnitUtils.usersUnitCode(request);
                hsql = "from " + News.class.getName() +
                        " as news where ((news.unitcode = ? or news.unitcode = ?) and news.patient = ?) or news.everyone = ?";
                params = new Object[]{unitcode, "all", 1, 1};
                types = new Type[]{Hibernate.STRING, Hibernate.STRING, Hibernate.INTEGER, Hibernate.INTEGER};
            }
        }
        List items = getNewsList(hsql, params, types);
        request.setAttribute("newses", items);
    }

    public static void putAppropriateNewsForEditInRequest(HttpServletRequest request) throws HibernateException {
        String hsql = "";
        Object[] params = new Object[]{};
        Type[] types = new Type[]{};
        Principal principal = request.getUserPrincipal();
        if (principal == null) {
            hsql = "from " + News.class.getName() + " as news where news.everyone = ?";
            params = new Object[]{1};
            types = new Type[]{Hibernate.INTEGER};
        } else {
            User user = (User) HibernateUtil.getPersistentObject(User.class, request.getUserPrincipal().getName());
            String userType = user.getRole();
            if ("superadmin".equals(userType)) {
                hsql = "from " + News.class.getName() + " as news";
            } else if ("unitadmin".equals(userType)) {
                String unitcode = UnitUtils.usersUnitCode(request);
                hsql = "from " + News.class.getName() +
                        " as news where (news.unitcode = ? and (news.admin = ? or news.patient = ?)) ";
                params = new Object[]{unitcode, 1, 1};
                types = new Type[]{Hibernate.STRING, Hibernate.INTEGER, Hibernate.INTEGER};
            }
        }
        List items = getNewsList(hsql, params, types);
        request.setAttribute("newses", items);
    }

    private static List getNewsList(String hsql, Object[] params, Type[] types) {
        List items = null;
        try {
            Session session = HibernateUtil.currentSession();
            Transaction tx = session.beginTransaction();
            items = session.find(hsql, params, types);
            tx.commit();
            HibernateUtil.closeSession();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return items;

    }


}
