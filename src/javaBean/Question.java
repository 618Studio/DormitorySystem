package javaBean;

public class Question {
	private String Sno; 
    private int future;
    private String part2_3;
    private int berth;
   
    public Question() {
		Sno = null;
		this.future = -1;
		this.part2_3 = null;
		this.berth = -1;
	}
    
	public Question(String sno, int future, String part2_3, int berth) {
		Sno = sno;
		this.future = future;
		this.part2_3 = part2_3;
		this.berth = berth;
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
	public int getBerth() {
		return berth;
	}
	public void setBerth(int berth) {
		this.berth = berth;
	}
}
