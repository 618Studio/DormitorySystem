package javaBean;

public class Score {
	private String mySno;
	private String otherSno;
	private int score;
	public Score(){
		this.mySno = null;
		this.otherSno = null;
		this.score = 0;
	}
	
	public Score(String mySno, String otherSno, int score) {
		this.mySno = mySno;
		this.otherSno = otherSno;
		this.score = score;
	}
	public String getMySno() {
		return mySno;
	}
	public void setMySno(String mySno) {
		this.mySno = mySno;
	}
	public String getOtherSno() {
		return otherSno;
	}
	public void setOtherSno(String otherSno) {
		this.otherSno = otherSno;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
}
