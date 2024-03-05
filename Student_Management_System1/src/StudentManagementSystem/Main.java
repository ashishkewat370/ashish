package StudentManagementSystem;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;
import InterfaceImpl.UserDAOImpl;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = scanner.nextLine();
		System.out.print("Enter password: ");
		String password = scanner.nextLine();
		DatabaseConnection dbConn = new DatabaseConnection();
		Connection conn = null;
		conn = dbConn.getConnection();
		try {
			UserDAO userDAO = new UserDAO(conn);
			boolean isValid = userDAO.validateUser(username, password);

			if (isValid) {
				System.out.println("Access granted. Welcome!");
				// Proceed with the application logic for valid users
				displayMenu(scanner);
			} else {
				System.out.println("Invalid username or password. Access denied.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
//            }
			}
		}
	}

	private static void displayMenu(Scanner scanner) {
//		 private static void displayMenu(Scanner scanner) {
		boolean exit = false;
		while (!exit) {
			System.out.println("\nMenu:");
			System.out.println("1. Manage Student Details");
			System.out.println("2. Manage Attendance");
			System.out.println("3. Manage Subjects");
			System.out.println("4. Exit");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				System.out.println("Managing Student Details...");
				manageStudentDetails(scanner);
				break;
			case 2:
				System.out.println("Managing Attendance...");
				// Implement attendance management logic here
				manageAttendance(scanner);
				break;
			case 3:
				System.out.println("Managing Subjects...");
				// Implement subject management logic here
				manageSubject(scanner);
				break;
			case 4:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}

	private static void manageSubject(Scanner scanner) {
		// TODO Auto-generated method stub
		SubjectDAO subjectDAO;
		boolean exit = false;
		while (!exit) {
			subjectDAO = new SubjectDAO(DatabaseConnection.getConnection());
			System.out.println("\nSubject Management:");
			System.out.println("1. Add Subject");
			System.out.println("2. Assign Subject Based on StudentId");
			
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); //
			switch (choice) {
			case 1:
				    System.out.print("Enter subject ID: ");
			        int subjectId = scanner.nextInt();
			        System.out.print("Enter subject name: ");
			        String subjectName = scanner.next();
			        System.out.print("Enter class level: ");
			        int classLevel = scanner.nextInt();

			        // Create a new Subject object and add it to the database
			        Subject subject = new Subject(subjectId, subjectName, classLevel);
			        subjectDAO.addSubject(subject);
			}

	}
	}

	private static void manageAttendance(Scanner scanner) {
		// TODO Auto-generated method stub
		AttendanceDAO attendanceDAO;
		boolean exit = false;
		while (!exit) {
			attendanceDAO = new AttendanceDAO(DatabaseConnection.getConnection());
			System.out.println("\nStudent Attendance Management:");
			System.out.println("1. Add Attendance");
			System.out.println("2. Update Attendance");
			System.out.println("3. List All Students Who are Present On Particular Date");
			System.out.println("4. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); //
			switch (choice) {
			case 1: // Add Attendance
				System.out.print("Enter student ID: ");
				int studentId = scanner.nextInt();
				System.out.print("Enter status (Present/Absent): ");
				String status = scanner.next();
				System.out.print("Enter date (YYYY-MM-DD): ");
				String date = scanner.next();
				try {
					attendanceDAO.addAttendance(studentId, status, date);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Attendance added successfully.");
				break;
			case 2: // Update Attendance
				System.out.print("Enter student ID: ");
				studentId = scanner.nextInt();
				System.out.print("Enter date (YYYY-MM-DD): ");
				date = scanner.next();
				System.out.print("Enter new status (Present/Absent): ");
				status = scanner.next();
				try {
					attendanceDAO.updateAttendanceByStudentId(studentId, status, date);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Attendance updated successfully.");
				break;
			case 3: // List All Students Who are Present On Particular Date
				System.out.print("Enter date to check for present students (YYYY-MM-DD): ");
				date = scanner.next();
				LocalDate specificDate = LocalDate.parse(date);
				List<Integer> presentStudents = attendanceDAO.getPresentStudentsOnDate(specificDate);
				System.out.println("Students present on " + specificDate + ": " + presentStudents);
				break;
			case 4: // Exit
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}

	}

	private static void manageStudentDetails(Scanner scanner) {
		// TODO Auto-generated method stub
		StudentDAO studentDAO;
		boolean exit = false;
		while (!exit) {
			studentDAO = new StudentDAO(DatabaseConnection.getConnection());
			System.out.println("\nStudent Details Management:");
			System.out.println("1. Add Student");
			System.out.println("2. Update Student");
			System.out.println("3. Delete Student");
			System.out.println("4. List All Students");
			System.out.println("5. Search Student By Id");
			System.out.println("6. Back to Main Menu");
			System.out.print("Enter your choice: ");
			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
			case 1:
				// Implement logic to add a student
				System.out.print("Enter student Id: ");
				int studentId = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Enter student Name: ");
				String stdName = scanner.nextLine();
				System.out.print("Enter Guardian Name: ");
				String stdGuardianName = scanner.nextLine();
				System.out.print("Enter Blood Group: ");
				String stdBlood = scanner.nextLine();
				System.out.print("Enter Phone Number: ");
				String stdPhone = scanner.nextLine();
				System.out.print("Enter City Name: ");
				String stdCity = scanner.nextLine();
				System.out.print("Enter Class: ");
				int stdClass = scanner.nextInt();
				scanner.nextLine();

				// Add logic to gather other student details
				Student newStudent = new Student();
				newStudent.setStudentId(studentId);
				newStudent.setStdName(stdName);
				newStudent.setStdGuardianName(stdGuardianName);
				newStudent.setStdBlood(stdBlood);
				newStudent.setStdPhone(stdPhone);
				newStudent.setStdCity(stdCity);
				newStudent.setStdClass(stdClass);
				// Set other fields
				studentDAO.createStudent(newStudent);
				break;

			case 2:
				// Implement logic to update a student
				System.out.print("Enter student ID to update: ");
				int idToUpdate = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Fetch the existing student details to update
				Student studentToUpdate = studentDAO.readStudent(idToUpdate);
				if (studentToUpdate != null) {
					System.out.print("Enter new student Name (current: " + studentToUpdate.getStdName() + "): ");
					String newStdName = scanner.nextLine();
					System.out
							.print("Enter new Guardian Name (current: " + studentToUpdate.getStdGuardianName() + "): ");
					String newStdGuardianName = scanner.nextLine();
					System.out.print("Enter new Blood Group (current: " + studentToUpdate.getStdBlood() + "): ");
					String newStdBlood = scanner.nextLine();
					System.out.print("Enter new Phone Number (current: " + studentToUpdate.getStdPhone() + "): ");
					String newStdPhone = scanner.nextLine();
					System.out.print("Enter new City Name (current: " + studentToUpdate.getStdCity() + "): ");
					String newStdCity = scanner.nextLine();
					System.out.print("Enter new Class (current: " + studentToUpdate.getStdClass() + "): ");
					int newStdClass = scanner.nextInt();
					scanner.nextLine(); // Consume newline

					// Update the student details
					studentToUpdate.setStdName(newStdName.isEmpty() ? studentToUpdate.getStdName() : newStdName);
					studentToUpdate.setStdGuardianName(
							newStdGuardianName.isEmpty() ? studentToUpdate.getStdGuardianName() : newStdGuardianName);
					studentToUpdate.setStdBlood(newStdBlood.isEmpty() ? studentToUpdate.getStdBlood() : newStdBlood);
					studentToUpdate.setStdPhone(newStdPhone.isEmpty() ? studentToUpdate.getStdPhone() : newStdPhone);
					studentToUpdate.setStdCity(newStdCity.isEmpty() ? studentToUpdate.getStdCity() : newStdCity);
					studentToUpdate.setStdClass(newStdClass == 0 ? studentToUpdate.getStdClass() : newStdClass);

					// Call the DAO method to update the student in the database
					studentDAO.updateStudent(studentToUpdate);
					System.out.println("Student details updated successfully.");
				} else {
					System.out.println("Student not found.");
				}
				break;

			case 3:
				// Implement logic to delete a student
				System.out.print("Enter student ID to delete: ");
				int idToDelete = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Call the DAO method to delete the student from the database
				studentDAO.deleteStudent(idToDelete);
				System.out.println("Student with ID " + idToDelete + " has been deleted successfully.");
				break;

			case 4:
				// Implement logic to list all students
				List<Student> allStudents = studentDAO.getAllStudents();
				if (allStudents.isEmpty()) {
					System.out.println("No students found.");
				} else {
					System.out.println("Listing all students:");
					for (Student student : allStudents) {
						System.out.println("Student ID: " + student.getStudentId() + ", Name: " + student.getStdName()
								+ ", Guardian Name: " + student.getStdGuardianName() + ", Blood Group: "
								+ student.getStdBlood() + ", Phone Number: " + student.getStdPhone() + ", City: "
								+ student.getStdCity() + ", Class: " + student.getStdClass());
					}
				}
				break;
			case 5:
				// Implement logic to search student by Id
				System.out.print("Enter student ID to search: ");
				int idToSearch = scanner.nextInt();
				scanner.nextLine(); // Consume newline

				// Call the DAO method to search the student by ID
				Student student = studentDAO.readStudent(idToSearch);
				if (student != null) {
					System.out.println("Student found:");
					System.out.println("Student ID: " + student.getStudentId());
					System.out.println("Name: " + student.getStdName());
					System.out.println("Guardian Name: " + student.getStdGuardianName());
					System.out.println("Blood Group: " + student.getStdBlood());
					System.out.println("Phone Number: " + student.getStdPhone());
					System.out.println("City: " + student.getStdCity());
					System.out.println("Class: " + student.getStdClass());
				} else {
					System.out.println("No student found with ID " + idToSearch + ".");
				}
				break;

			case 6:
				exit = true;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		}
	}
}
