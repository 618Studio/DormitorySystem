package connectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChooseOperateDB {
	public static ResultSet getOrder(int future){
		String getorder = "SELECT Sno,Score FROM DormitorySystem.standardScore where Sno in(select Sno from question where Qfuture="+ future +") order by Score";
		return ConnectDB.query(getorder);
	}
	
	public static ResultSet getOrder(){
		String getorder = "SELECT Sno,Score FROM DormitorySystem.standardScore order by Score";
		return ConnectDB.query(getorder);
	}
	
	public static ResultSet getSameList(String mainSno){
		String getsamelist = "SELECT SotherNr FROM DormitorySystem.score where SmainNr = '"+mainSno+"' order by SameScore DESC;";
		return ConnectDB.query(getsamelist);
	}
	
	public static ResultSet getCompareList(String mainSno){
		String getcomparelist = "SELECT SotherNr FROM DormitorySystem.score where SmainNr = '"+mainSno+"' order by CompareScore DESC;";
		return ConnectDB.query(getcomparelist);
	}
	
	public static ResultSet checkMatch(String sno){
		String checkmatch = "SELECT Mno1,Mno2 FROM DormitorySystem.matchstudents where type = 1 and (Mno1 = '"+sno+"' or Mno2 = '"+sno+"');";
		return ConnectDB.query(checkmatch);	
	}
	
	public static ResultSet getRoom(int sex){
		String getroom = "SELECT DroomNr,capacity FROM DormitorySystem.dormitory where finish = 0 and sex="+sex;
		return ConnectDB.query(getroom);
	}
	
	public static void set4PeopleRoom(String[] sno,String roomNr){
		String insert1 = "update students set SroomNr = '"+roomNr+"' where Sno = '"+sno[0]+"'";
		String insert2 = "update students set SroomNr = '"+roomNr+"' where Sno = '"+sno[1]+"'";
		String insert3 = "update students set SroomNr = '"+roomNr+"' where Sno = '"+sno[2]+"'";
		String insert4 = "update students set SroomNr = '"+roomNr+"' where Sno = '"+sno[3]+"'";
		String update = "update dormitory set finish = 1 where DroomNr = '"+roomNr+"'";
		ConnectDB.update(insert1);
		ConnectDB.update(insert2);
		ConnectDB.update(insert3);
		ConnectDB.update(insert4);
		ConnectDB.update(update);
	}
	
	public static boolean checkHaveRoom(String sno) throws SQLException{
		String check = "SELECT SroomNr FROM DormitorySystem.students where Sno = '"+sno+"'";
		ResultSet res = ConnectDB.query(check);
		res.next();
		if (res.getString("SroomNr")==null){
			return false;
		}else return true;
	}
	
	public static int checkSex(String sno) throws SQLException{
		String check = "SELECT Sgender FROM DormitorySystem.students where Sno = '"+sno+"'";
		ResultSet res = ConnectDB.query(check);
		res.next();
		return res.getInt("Sgender");
	}
	
	public static ResultSet finalCheck(int sex){
		String finalCheck = "select Sno from question where Sno in(select Sno from students where SroomNr is null and Sgender = "+sex+")";
		return ConnectDB.query(finalCheck);
	}
	
	public static void clearDB(){
		String truncateMatch = "truncate table matchstudents;";
		String truncateScore = "truncate table score;";
		String truncateStandard = "truncate table standardScore;";
		ConnectDB.query(truncateMatch);
		ConnectDB.query(truncateScore);
		ConnectDB.query(truncateStandard);
	}
	
	public static void clearAllData(){
		String truncateMatch = "truncate table matchstudents;";
		String truncateScore = "truncate table score;";
		String truncateStandard = "truncate table standardScore;";
		String truncateQuestion = "truncate table question;";
		String truncateStudent = "delete from students where 1=1;";
		String truncateDormitory = "delete from dormitory where 1=1;";
		ConnectDB.query(truncateMatch);
		ConnectDB.query(truncateScore);
		ConnectDB.query(truncateStandard);
		ConnectDB.query(truncateQuestion);
		ConnectDB.query(truncateStudent);
		ConnectDB.query(truncateDormitory);
	}
}
