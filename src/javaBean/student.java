package javaBean;

import java.util.List;

public class student {
	private String id;//student id
	private String name;//name
	private String gender;//
	private String grade;//grade
	private List<String> favoriteGayId;//id of gay you want
	private List<String> answers;//questions' answer you choose 
	
	student(String id,String name,String gender,String grade){
		this.id = id;
		this.name = name;
		this.gender = gender;
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
	
	String getGender(){
		return this.gender;
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
	//add answer
	void addAnswer(String answer){
		this.answers.add(answer);
	}
	
}
