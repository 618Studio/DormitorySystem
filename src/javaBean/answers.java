package javaBean;

public class answers {
	private String id;//student id
	private String[] answer;//answer
	private int capacity;// the number of answers
	
	answers(String id){
		this.id = id;
		this.capacity = 17;
		answer = new String[this.capacity]; 
	}
	//parameter result is the data from form,so you need to translate form data into String array at first
	void dealWithArr(String[] result){
		for(int i=0;i<this.capacity;i++){
			if(result[i].equals("no")||result[i].equals("studyAbroad")){
				answer[i] = "0";
			}else if(result[i].equals("yes")||result[i].equals("graudateStudy")){
				answer[i] = "1";
			}else if(result[i].equals("work")){
				answer[i] = "2";
			}else if(result[i].equals("notSure")){
				answer[i] = "3";
			}else{
				answer[i] = result[i];
			}
		}
	}
	
	String getId(){
		return this.id;
	}
	
	void setId(String id){
		this.id = id;
	}
	
	String[] getAnswers(){
		return this.answer;
	}
}
