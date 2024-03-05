package StudentManagementSystem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
     Connection con ;
	
	public StudentDAO(Connection con){
		this.con=con;
	}

 
    public void createStudent(Student student) {
        String query = "INSERT INTO student (studentId, stdName, stdGuardianName, stdBlood, stdPhone, stdCity, stdClass) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
        	pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getStdName());
            pstmt.setString(3, student.getStdGuardianName());
            pstmt.setString(4, student.getStdBlood());
            pstmt.setString(5, student.getStdPhone());
            pstmt.setString(6, student.getStdCity());
            pstmt.setInt(7, student.getStdClass());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

   
    public Student readStudent(int studentId) {
        String query = "SELECT * FROM student WHERE studentId = ?";
        Student student = null;
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                student = new Student(rs.getInt("studentId"), rs.getString("stdName"), rs.getString("stdGuardianName"), rs.getString("stdBlood"), rs.getString("stdPhone"), rs.getString("stdCity"), rs.getInt("stdClass"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

   
    public void updateStudent(Student student) {
        String query = "UPDATE student SET stdName = ?, stdGuardianName = ?, stdBlood = ?, stdPhone = ?, stdCity = ?, stdClass = ? WHERE studentId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
        	pstmt.setInt(1, student.getStudentId());
            pstmt.setString(2, student.getStdName());
            pstmt.setString(3, student.getStdGuardianName());
            pstmt.setString(4, student.getStdBlood());
            pstmt.setString(5, student.getStdPhone());
            pstmt.setString(6, student.getStdCity());
            pstmt.setInt(7, student.getStdClass());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public void deleteStudent(int studentId) {
        String query = "DELETE FROM student WHERE studentId = ?";
        try (PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, studentId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM student";
        try (PreparedStatement pstmt = con.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                students.add(new Student(rs.getInt("studentId"), rs.getString("stdName"), rs.getString("stdGuardianName"), rs.getString("stdBlood"), rs.getString("stdPhone"), rs.getString("stdCity"), rs.getInt("stdClass")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }
}
