package connectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaBean.Question;

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
	
	public static Question[][] getQuestionResult(){
		Question[][] result = new Question[5][];
		result[0] = null;
		for (int i=1;i<=4;i++){
			String sql = "select * from question where Qfuture="+i;
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
		        			    res.getInt("Qberth")
		        				);
		        	}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			}     
		}
		return result;
	}
}
