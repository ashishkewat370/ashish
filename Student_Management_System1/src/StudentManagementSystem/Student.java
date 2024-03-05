package StudentManagementSystem;
public class Student {
	private int studentId;
    private String stdName;
    private String stdGuardianName;
    private String stdBlood;
    private String stdPhone;
    private String stdCity;
    private int stdClass;
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdGuardianName() {
		return stdGuardianName;
	}
	public void setStdGuardianName(String stdGuardianName) {
		this.stdGuardianName = stdGuardianName;
	}
	public String getStdBlood() {
		return stdBlood;
	}
	public void setStdBlood(String stdBlood) {
		this.stdBlood = stdBlood;
	}
	public String getStdPhone() {
		return stdPhone;
	}
	public void setStdPhone(String stdPhone) {
		this.stdPhone = stdPhone;
	}
	public String getStdCity() {
		return stdCity;
	}
	public void setStdCity(String stdCity) {
		this.stdCity = stdCity;
	}
	public int getStdClass() {
		return stdClass;
	}
	public void setStdClass(int stdClass) {
		this.stdClass = stdClass;
	}
	public Student(int studentId, String stdName, String stdGuardianName, String stdBlood, String stdPhone,
			String stdCity, int stdClass) {
		super();
		this.studentId = studentId;
		this.stdName = stdName;
		this.stdGuardianName = stdGuardianName;
		this.stdBlood = stdBlood;
		this.stdPhone = stdPhone;
		this.stdCity = stdCity;
		this.stdClass = stdClass;
	}
    public Student() {
    	
    }
    
}
