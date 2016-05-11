package javaBean;

public class Question {
	private String Sno; 
    private int future;
    private String part2_3;
    private String want;
   
    public Question() {
		Sno = null;
		this.future = -1;
		this.part2_3 = null;
		this.want = null;
	}
    
	public Question(String sno, int future, String part2_3, String want) {
		Sno = sno;
		this.future = future;
		this.part2_3 = part2_3;
		this.want = want;
	}
	
	public String getSno() {
		return Sno;
	}
	public void setSno(String sno) {
		Sno = sno;
	}
	public int getFuture() {
		return future;
	}
	public void setFuture(int future) {
		this.future = future;
	}
	public String getPart2_3() {
		return part2_3;
	}
	public void setPart2_3(String part2_3) {
		this.part2_3 = part2_3;
	}
	public String getWant() {
		return want;
	}
	public void setWant(String want) {
		this.want = want;
	}
}
