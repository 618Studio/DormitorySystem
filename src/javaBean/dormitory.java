package javaBean;

import javax.swing.JOptionPane;

public class dormitory {
	private String roomNr;//dormitory id
	private String address;//dormitory address
	private int capacity;//the capacity of dormitory
	private String direction;//south or north
	private String dormitoryLeaderId;//dormitory leader
	private int nrOfPerson;
	public student[] stu;

	dormitory(String roomNr,String address,int capacity,String direction){
		this.roomNr = roomNr;
		this.address = address;
		this.capacity = capacity;
		this.direction = direction;
		this.nrOfPerson = 0;
		this.stu = new student[capacity];
	}
	//add student into dormitory room
	void InitStudent(String id,String name,String gender,String gpa,String grade){
		if(this.nrOfPerson==this.capacity){
			JOptionPane.showMessageDialog(null, "The dormitory is full of students.");
		}else{
			stu[this.nrOfPerson] = new student(id,name,gender,gpa,grade);
			this.nrOfPerson++;
			if(this.nrOfPerson==this.capacity){
				findDormitoryLeaderId();
			}
		}
	}
	
	private void findDormitoryLeaderId(){
		student max = stu[0];
		for(int i = 1;i < this.capacity;i++){
			if(Float.parseFloat(max.getGpa())<Float.parseFloat(stu[i].getGpa())){
				max = stu[i];
			}
		}
		this.dormitoryLeaderId = max.getId();
	}
	
	String getRoomNr(){
		return this.roomNr;
	}
	
	String getAddress(){
		return this.address;
	}
	
	int getCapacity(){
		return this.capacity;
	}
	
	String getDirection(){
		return this.direction;
	}
	
	String getDirectionLeaderId(){
		return this.dormitoryLeaderId;
	}
	
	int getNrOfPerson(){
		return this.nrOfPerson;
	}
	
	void setRoomNr(String roomNr){
		this.roomNr = roomNr;
	}
	
	void setAddress(String address){
		this.address = address;
	}
	
	void setCapacity(int capacity){
		this.capacity = capacity;
	}
	
	void setDirection(String direction){
		this.direction = direction;
	}
	
	void setDormitoryLeaderId(String dormitoryLeaderId){
		this.dormitoryLeaderId = dormitoryLeaderId;
	}
}
