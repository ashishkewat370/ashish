package StudentManagementSystem;

public class Subject {
     private int subjectId;
     private String subjectName;
     private int classLevel;
	public int getSubjectId() {
		return subjectId;
	}
	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getClassLevel() {
		return classLevel;
	}
	public void setClassLevel(int classLevel) {
		this.classLevel = classLevel;
	}
	public Subject(int subjectId, String subjectName, int classLevel) {
		super();
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.classLevel = classLevel;
	}
     public Subject() {
    	 
     }
}
