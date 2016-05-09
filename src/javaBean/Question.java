package javaBean;

public class Question {
	private String Sno; 
    private int future;
    private int part2_1;
    private int part2_2;
    private int part2_3;
    private int part2_4;
    private int part2_5;
    private int part2_6;
    private int part3_1;
    private int part3_2;
    private int part3_3;
    private int part3_4;
    private int part3_5;
    private int part3_6;
    private int part3_7;
    private int part3_8;
    private int part3_9;
    private String want;
       
    public Question(){
    		this.Sno = null;
		this.future = -1;
		this.part2_1 = -1;
		this.part2_2 = -1;
		this.part2_3 = -1;
		this.part2_4 = -1;
		this.part2_5 = -1;
		this.part2_6 = -1;
		this.part3_1 = -1;
		this.part3_2 = -1;
		this.part3_3 = -1;
		this.part3_4 = -1;
		this.part3_5 = -1;
		this.part3_6 = -1;
		this.part3_7 = -1;
		this.part3_8 = -1;
		this.part3_9 = -1;
		this.want = null;
    }
    
	public Question(String sno, int future, int part2_1, int part2_2, int part2_3, int part2_4, int part2_5,
			int part2_6, int part3_1, int part3_2, int part3_3, int part3_4, int part3_5, int part3_6, int part3_7,
			int part3_8, int part3_9, String want) {
		this.Sno = sno;
		this.future = future;
		this.part2_1 = part2_1;
		this.part2_2 = part2_2;
		this.part2_3 = part2_3;
		this.part2_4 = part2_4;
		this.part2_5 = part2_5;
		this.part2_6 = part2_6;
		this.part3_1 = part3_1;
		this.part3_2 = part3_2;
		this.part3_3 = part3_3;
		this.part3_4 = part3_4;
		this.part3_5 = part3_5;
		this.part3_6 = part3_6;
		this.part3_7 = part3_7;
		this.part3_8 = part3_8;
		this.part3_9 = part3_9;
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
	public int getPart2_1() {
		return part2_1;
	}
	public void setPart2_1(int part2_1) {
		this.part2_1 = part2_1;
	}
	public int getPart2_2() {
		return part2_2;
	}
	public void setPart2_2(int part2_2) {
		this.part2_2 = part2_2;
	}
	public int getPart2_3() {
		return part2_3;
	}
	public void setPart2_3(int part2_3) {
		this.part2_3 = part2_3;
	}
	public int getPart2_4() {
		return part2_4;
	}
	public void setPart2_4(int part2_4) {
		this.part2_4 = part2_4;
	}
	public int getPart2_5() {
		return part2_5;
	}
	public void setPart2_5(int part2_5) {
		this.part2_5 = part2_5;
	}
	public int getPart2_6() {
		return part2_6;
	}
	public void setPart2_6(int part2_6) {
		this.part2_6 = part2_6;
	}
	public int getPart3_1() {
		return part3_1;
	}
	public void setPart3_1(int part3_1) {
		this.part3_1 = part3_1;
	}
	public int getPart3_2() {
		return part3_2;
	}
	public void setPart3_2(int part3_2) {
		this.part3_2 = part3_2;
	}
	public int getPart3_3() {
		return part3_3;
	}
	public void setPart3_3(int part3_3) {
		this.part3_3 = part3_3;
	}
	public int getPart3_4() {
		return part3_4;
	}
	public void setPart3_4(int part3_4) {
		this.part3_4 = part3_4;
	}
	public int getPart3_5() {
		return part3_5;
	}
	public void setPart3_5(int part3_5) {
		this.part3_5 = part3_5;
	}
	public int getPart3_6() {
		return part3_6;
	}
	public void setPart3_6(int part3_6) {
		this.part3_6 = part3_6;
	}
	public int getPart3_7() {
		return part3_7;
	}
	public void setPart3_7(int part3_7) {
		this.part3_7 = part3_7;
	}
	public int getPart3_8() {
		return part3_8;
	}
	public void setPart3_8(int part3_8) {
		this.part3_8 = part3_8;
	}
	public int getPart3_9() {
		return part3_9;
	}
	public void setPart3_9(int part3_9) {
		this.part3_9 = part3_9;
	}
	public String getWant() {
		return want;
	}
	public void setWant(String want) {
		this.want = want;
	}
}
