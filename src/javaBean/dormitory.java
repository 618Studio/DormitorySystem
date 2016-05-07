package javaBean;

import javax.swing.JOptionPane;

public class dormitory {
	private String roomNr;//dormitory id
	private String address;//dormitory address
	private int capacity;//the maximum number of students 
	private int nrOfPerson;//the number of students in the dormitory at present
	public student[] stu;

	dormitory(String roomNr,String address,int capacity){
		this.roomNr = roomNr;
		this.address = address;
		this.capacity = capacity;
		this.nrOfPerson = 0;
		this.stu = new student[capacity];
	}
	
	void InitStudent(String id,String name,String gender,String grade){
		if(this.nrOfPerson==this.capacity){
			JOptionPane.showMessageDialog(null, "The dormitory is full of students.");
		}else{
			stu[this.nrOfPerson] = new student(id,name,gender,grade);
			this.nrOfPerson++;
		}
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
	
}
