package javaBean;

public class answers {
	private String id;//student id
	private int[] answer;//answer
	private int capacity;// the number of answers
	
	answers(String id){
		this.id = id;
		this.capacity = 17;
		answer = new int[this.capacity]; 
	}
	
	void dealWithArr(String[] result){
		for(int i=0;i<this.capacity;i++){
			if(result[i].equals("q"+(i+1)+"a")){
				answer[i] = 0;
			}else if(result[i].equals("q"+(i+1)+"b")){
				answer[i] = 1;
			}else if(result[i].equals("q"+(i+1)+"c")){
				answer[i] = 2;
			}else if(result[i].equals("q"+(i+1)+"d")){
				answer[i] = 3;
			}
		}
	}
	
	String getId(){
		return this.id;
	}
	
	void setId(String id){
		this.id = id;
	}
	
	int[] getAnswers(){
		return this.answer;
	}
}
