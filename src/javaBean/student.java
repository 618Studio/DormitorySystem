package javaBean;

import java.util.List;

public class student {
	private String id;//学号
	private String name;//姓名
	private String gender;//性别
	private String grade;//年级
	private String gpa;//绩点
	private String phone;//手机号码
	private List<String> favoriteGayId;//想要的基友的id
	private List<String> answers;//问卷答案
	
	student(String id,String name,String gpa,String phone,String gender,String grade){
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.phone = phone;
		this.gender = gender;
		this.grade = grade;
	}
	
	String getGrade(){
		return this.grade;
	}
	
	String getId(){
		return this.id;
	}
	
	String getGpa(){
		return this.gpa;
	}
	
	String getName(){
		return this.name;
	}
	
	String getGender(){
		return this.gender;
	}
	
	String getPhone(){
		return this.phone;
	}
	

	List<String> getFavoriteGay(){
		return this.favoriteGayId;
	}
	
	List<String> getAnswers(){
		return this.answers;
	}
	
	void setId(String id){
		this.id = id;
	}
	
	void setName(String name){
		this.name = name;
	}
	
	void setGpa(String gpa){
		this.gpa = gpa;
	}
	
	void setPhone(String phone){
		this.phone = phone;
	}
	
	void setGrade(String grade){
		this.grade = grade;
	}
	
	void setGender(String gender){
		this.gender = gender;
	}
	
	//添加想要的基友，参数为基友id
	void addGay(String gayId){
		this.favoriteGayId.add(gayId);
	}
	//添加答案
	void addAnswer(String answer){
		this.answers.add(answer);
	}
	
}
