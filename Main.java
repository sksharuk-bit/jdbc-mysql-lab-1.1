import java.sql.*;

public class Main {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "password";

    public static void main(String[] args) {
        String sql = "SELECT * FROM users";
        
        try (Connection conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String email = rs.getString("email");
                System.out.println("User ID: " + id + ", Username: " + username + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
