package javaBean;

import java.util.List;

public class student {
	private String id;//ѧ��
	private String name;//����
	private String gender;//�Ա�
	private String grade;//�꼶
	private String gpa;//����
	private String phone;//�ֻ�����
	private List<String> favoriteGayId;//��Ҫ�Ļ��ѵ�id
	private List<String> answers;//�ʾ��
	
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
	
	//�����Ҫ�Ļ��ѣ�����Ϊ����id
	void addGay(String gayId){
		this.favoriteGayId.add(gayId);
	}
	//��Ӵ�
	void addAnswer(String answer){
		this.answers.add(answer);
	}
	
}
