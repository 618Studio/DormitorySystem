package javaBean;

import java.util.List;

public class student {
	private String id;     				//student id
	private String name;   				//name
	private String gender; 				//gender
	private String gpa;    				//gpa
	private String grade;    			//grade
	private List<String> favoriteGayId; //id of gay you want
	
	student(String id,String name,String gender,String gpa,String grade){
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.gpa = gpa;
		this.grade = grade;
	}
	
	String getGrade(){
		return this.grade;
	}
	
	String getId(){
		return this.id;
	}
	
	String getName(){
		return this.name;
	}
	
	String getGpa(){
		return this.gpa;
	}
	
	String getGender(){
		return this.gender;
	}

	List<String> getFavoriteGay(){
		return this.favoriteGayId;
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
	
	void setGrade(String grade){
		this.grade = grade;
	}
	
	void setGender(String gender){
		this.gender = gender;
	}
	
	//choose your favorite gay
	void addGay(String gayId){
		this.favoriteGayId.add(gayId);
	}

}
