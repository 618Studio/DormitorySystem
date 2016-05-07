package javaBean;

import javax.swing.JOptionPane;

public class dormitory {
	private String roomNr;//寝室编号
	private String address;//寝室地址
	private int capacity;//该寝室能住多少人
	private int nrOfPerson;
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
