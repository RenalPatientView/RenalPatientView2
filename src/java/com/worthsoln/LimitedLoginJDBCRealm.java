package com.worthsoln;



public class LimitedLoginJDBCRealm { //extends JDBCRealm {

//    private String userFailedLoginCount = null;
//    private String userFailedLoginDate = null;
//
//    public String getUserFailedLoginCount() {
//        return userFailedLoginCount;
//    }
//
//    public void setUserFailedLoginCount(String userFailedLoginCount) {
//        this.userFailedLoginCount = userFailedLoginCount;
//    }
//
//    public String getUserFailedLoginDate() {
//        return userFailedLoginDate;
//    }
//
//    public void setUserFailedLoginDate(String userFailedLoginDate) {
//        this.userFailedLoginDate = userFailedLoginDate;
//    }
//
//    public synchronized Principal authenticate(Connection connection, String s, String s1) throws SQLException {
//        Principal principal = super.authenticate(connection, s, s1);
//        if (principal == null) {
//            try {
//                Connection conn = open();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return principal;
//    }
//
//    protected FailedLoginRecord getFailedLogins(String username) {
//        // Look up the user's credentials
//        FailedLoginRecord failedLoginRecord = null;
//        PreparedStatement stmt = null;
//        ResultSet rs = null;
//
//        // Number of tries is the number of attempts to connect to the database
//        // during this login attempt (if we need to open the database)
//        // This needs rewritten wuth better pooling support, the existing code
//        // needs signature changes since the Prepared statements needs cached
//        // with the connections.
//        // The code below will try twice if there is a SQLException so the
//        // connection may try to be opened again. On normal conditions (including
//        // invalid login - the above is only used once.
//        int numberOfTries = 2;
//        while (numberOfTries > 0) {
//            try {
//                // Ensure that we have an open database connection
//                open();
//                try {
//                    stmt = failedLogins(dbConnection, username);
//                    rs = stmt.executeQuery();
//                    if (rs.next()) {
//                        int failureCount = rs.getInt(1);
//                        Calendar failureDate = Calendar.getInstance();
//                        failureDate.setTimeInMillis(rs.getDate(2).getTime());
//                        failedLoginRecord = new FailedLoginRecord(failureCount, failureDate);
//                    }
//                    rs.close();
//                    rs = null;
//                    return failedLoginRecord;
//                } finally {
//                    if (rs != null) {
//                        try {
//                            rs.close();
//                        } catch (SQLException e) {
//                            ;
//                        }
//                    }
//                    dbConnection.commit();
//                }
//            } catch (SQLException e) {
//                if (dbConnection != null) {
//                    close(dbConnection);
//                }
//            }
//            numberOfTries--;
//        }
//        return (null);
//    }
//
//    protected PreparedStatement failedLogins(Connection dbConnection,
//                                             String username)
//            throws SQLException {
//        if (preparedCredentials == null) {
//            StringBuffer sb = new StringBuffer("SELECT ");
//            sb.append(userFailedLoginCount);
//            sb.append(" , ");
//            sb.append(userFailedLoginDate);
//            sb.append(" FROM ");
//            sb.append(userTable);
//            sb.append(" WHERE ");
//            sb.append(userNameCol);
//            sb.append(" = ?");
//            preparedCredentials =
//                    dbConnection.prepareStatement(sb.toString());
//        }
//        if (username == null) {
//            preparedCredentials.setNull(1, java.sql.Types.VARCHAR);
//        } else {
//            preparedCredentials.setString(1, username);
//        }
//        return (preparedCredentials);
//    }
}
