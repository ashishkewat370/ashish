package StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ServiceInterface.UserDAO;

public class UserDAO {
	Connection con ;
	
	public UserDAO(Connection con){
		this.con=con;
	}
    public boolean validateUser(String username, String password) {
        boolean isValid = false;
        String query = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            isValid = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
