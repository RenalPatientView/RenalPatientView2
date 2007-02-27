package com.worthsoln.patientview;

import java.util.ArrayList;
import com.worthsoln.database.StorableItem;

public class UserDao extends StorableItem {

    private User user;

    public UserDao(User user) {
        this.user = user;
    }

    public UserDao() {
        super();
    }

    public String[] getColumnNames() {
        return new String[]{"password", "role", "name", "nhsno", };
    }

    public ArrayList getColumnParameters() {
        ArrayList params = new ArrayList();

        params.add(user.getPassword());
        params.add(user.getRole());
        params.add(user.getName());
        params.add(user.getNhsno());

        return params;
    }

    public Object getIdParameter() {
        return user.getUsername();
    }

    public Class getTableMapper() {
        return User.class;
    }

    public String getIdColumnName() {
        return "username";
    }

    public String getTableName() {
        return "user";
    }
}
