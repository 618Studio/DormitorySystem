package hibernate;
// Generated 2016-5-17 22:41:26 by Hibernate Tools 4.3.1.Final

/**
 * Question generated by hbm2java
 */
public class Question implements java.io.Serializable {

	private String sno;
	private Students students;
	private int qfuture;
	private String qpart23;
	private String qwant;

	public Question() {
	}

	public Question(Students students, int qfuture, String qpart23) {
		this.students = students;
		this.qfuture = qfuture;
		this.qpart23 = qpart23;
	}

	public Question(Students students, int qfuture, String qpart23, String qwant) {
		this.students = students;
		this.qfuture = qfuture;
		this.qpart23 = qpart23;
		this.qwant = qwant;
	}

	public String getSno() {
		return this.sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public Students getStudents() {
		return this.students;
	}

	public void setStudents(Students students) {
		this.students = students;
	}

	public int getQfuture() {
		return this.qfuture;
	}

	public void setQfuture(int qfuture) {
		this.qfuture = qfuture;
	}

	public String getQpart23() {
		return this.qpart23;
	}

	public void setQpart23(String qpart23) {
		this.qpart23 = qpart23;
	}

	public String getQwant() {
		return this.qwant;
	}

	public void setQwant(String qwant) {
		this.qwant = qwant;
	}

}
