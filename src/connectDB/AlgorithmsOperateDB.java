package connectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaBean.Question;
import javaBean.Score;

public class AlgorithmsOperateDB {
	/*public static void main(String args[]){
		System.out.println("hello");
		Question[][] res=AlgorithmsOperateDB.getQuestionResult();
		for(int i=1;i<5;i++){
			System.out.println(res[i][0].getSno()+res[i][0].getFuture());
		}
	}*/
	
	public AlgorithmsOperateDB() {
	}
	
	//判断相互选择情况并加入数据库
	public static void dealWant() throws SQLException{
		String getSno_Qwant="SELECT Sno,Qwant FROM DormitorySystem.question;";
		ResultSet res = ConnectDB.query(getSno_Qwant);
		while(res.next()){
			String firSno = res.getString("Sno");
			String firWant = res.getString("Qwant");
			String testSex1 = "select Sgender from students where Sno = '"+firSno+"'";
			ResultSet Ssex1 = ConnectDB.query(testSex1);
			Ssex1.next();
			int firSex = Ssex1.getInt("Sgender");
			
			String secQuery = "select Qwant from DormitorySystem.question where Sno = '"+ firWant + "'";
			ResultSet secRes = ConnectDB.query(secQuery);
			if (secRes.next()==false) break;
			String secWant = secRes.getString("Qwant");
			String testSex2 = "select Sgender from students where Sno = '"+ firWant +"'";
			ResultSet Ssex2 = ConnectDB.query(testSex2);
			Ssex2.next();
			int secSex = Ssex2.getInt("Sgender");
			
			//判断性别问题
			if (secSex==firSex){
				if (secWant.equals(firSno)){
					String testRepeat = "select * from DormitorySystem.matchstudents where Mno1 = '" + firWant +"'";
					ResultSet test = ConnectDB.query(testRepeat);
					//判断是否已写入数据，避免数据冗余
					if (!test.next()){
						String insert = "insert into DormitorySystem.matchstudents value('"+ firSno +"','"+ firWant +"',"+ "1" +");";
						ConnectDB.update(insert);
					}
				}else{
					String insert = "insert into DormitorySystem.matchstudents value('"+ firSno +"','"+ firWant +"',"+ "0" +");";
					ConnectDB.update(insert);
				}
			}
		}
	}
	
	//按第一次分类返回调查结果
	public static Question[][] getQuestionResult(int sex){
		Question[][] result = new Question[5][];
		result[0] = null;
		for (int i=1;i<=4;i++){
			String sql = "select * from question where question.Sno in (select Sno from students where Sgender="+ sex +")and question.Qfuture ="+i;
			ResultSet res = ConnectDB.query(sql);
			try {
				res.last();
				int row = res.getRow();
		        res.beforeFirst();//光标回滚
		        	result[i] = new Question[row];
		        	int j=0;
		        	//将文件数据从数据库中读取写入javabean中
		        	while(res.next()){
		        		result[i][j++] = new Question(
		        				res.getString("Sno"),
		        				res.getInt("Qfuture"),
		        				res.getString("Qpart2_3"),
		        			    res.getString("Qwant")
		        				);
		        	}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}     
		}
		return result;
	}

	public static void storeSameSore(Score score){
		
	}
}
