package festivalPlanner.data_system;

import java.sql.*;

public class DatabaseConnection {

    private String databaseAddress = "jdbc:mysql://167.71.130.2:3306/festplanner_users";
    private String databaseUsername = "ApplicationAccess";
    private String databasePassword = "4ed6a481f14b4b9c98b05959e3d29782";

    private Connection databaseConnection;

    private Boolean connectionStatus;

    private String activeUser;

    public DatabaseConnection() throws SQLException {

        try {
            this.databaseConnection = DriverManager.getConnection(this.databaseAddress, this.databaseUsername, this.databasePassword);
            this.connectionStatus = true;
        } catch (SQLException e){
            this.connectionStatus = false;
            printSQLException(e);
        }

    }

    public ResultSet updateStageTable() throws SQLException {

        return null;
    }

    public String fetchUserOrganization() throws SQLException {

        PreparedStatement userOrganization = this.databaseConnection.prepareStatement("SELECT Organization FROM user WHERE username = ?");
        userOrganization.setString(1, this.activeUser);

        ResultSet databaseReply = userOrganization.executeQuery();
        databaseReply.next();

        return databaseReply.getString("Organization");
    }

    public boolean validateUser(String username, String password) throws SQLException {

        this.activeUser = username;

        PreparedStatement userValidationQuery = this.databaseConnection.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
        userValidationQuery.setString(1, username);
        userValidationQuery.setString(2, password);

        ResultSet databaseValidationReply = userValidationQuery.executeQuery();

        return databaseValidationReply.next();

    }

    public boolean connectionStatus(){
        return this.connectionStatus;
    }


    private static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}