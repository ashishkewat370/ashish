package StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubjectDAO {
	Connection con;

	public SubjectDAO(Connection con) {
		this.con = con;
	}
	
	public void addSubject(Subject subject) {
	    String sql = "INSERT INTO subject (subjectId, subjectName, classLevel) VALUES (?, ?, ?)";
	    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	        pstmt.setInt(1, subject.getSubjectId());
	        pstmt.setString(2, subject.getSubjectName());
	        pstmt.setInt(3, subject.getClassLevel());
	        pstmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
