package StudentManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {
	Connection con;

	public AttendanceDAO(Connection con) {
		this.con = con;
	}
	
	    private static final String ADD_ATTENDANCE = "INSERT INTO attendance (studentId, status, date) VALUES (?, ?, ?)";

	    public void addAttendance(int studentId, String status, String date) throws SQLException {
	        try (
//	        		Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement pstmt = con.prepareStatement(ADD_ATTENDANCE)) {
	            pstmt.setInt(1, studentId);
	            pstmt.setString(2, status);
	            pstmt.setString(3, date);
	            pstmt.executeUpdate();
	        }
	    }
	


	    private static final String UPDATE_ATTENDANCE_BY_STUDENT_ID_AND_DATE = "UPDATE attendance SET status = ? WHERE studentId = ? AND date = ?";

	    public void updateAttendanceByStudentId(int studentId, String status, String date) throws SQLException {
	        try (PreparedStatement pstmt = con.prepareStatement(UPDATE_ATTENDANCE_BY_STUDENT_ID_AND_DATE)) {
	            pstmt.setInt(1, studentId);
	            pstmt.setString(2, date);
	            pstmt.setString(3, status);
	            int rowsUpdated = pstmt.executeUpdate();
	            if (rowsUpdated > 0) {
	                System.out.println("Attendance updated successfully for student ID: " + studentId + " on date: " + date);
	            } else {
	                System.out.println("No attendance found to update for student ID: " + studentId + " on date: " + date);
	            }
	        }
	    }

	public List<Integer> getPresentStudentsOnDate(LocalDate date) {
		List<Integer> presentStudents = new ArrayList<>();
		String sql = "SELECT studentId FROM attendance WHERE status = 'Present' AND date = ?";
		try (PreparedStatement statement = con.prepareStatement(sql)) {
			statement.setDate(1, java.sql.Date.valueOf(date));
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				presentStudents.add(resultSet.getInt("studentId"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return presentStudents;
	}
}
