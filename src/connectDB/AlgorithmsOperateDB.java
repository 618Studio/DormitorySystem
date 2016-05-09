package connectDB;

import java.sql.ResultSet;
import java.sql.SQLException;

import javaBean.Question;

public class AlgorithmsOperateDB {
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
		        				res.getInt("Qpart2_1"),
		        				res.getInt("Qpart2_2"),
		        				res.getInt("Qpart2_3"),
		        				res.getInt("Qpart2_4"),
		        				res.getInt("Qpart2_5"),
		    					res.getInt("Qpart2_6"),
		   					res.getInt("Qpart3_1"),
		   					res.getInt("Qpart3_2"),
		        				res.getInt("Qpart3_3"),
		        				res.getInt("Qpart3_4"),
							res.getInt("Qpart3_5"),
		        				res.getInt("Qpart3_6"),
		        				res.getInt("Qpart3_7"),
		        				res.getInt("Qpart3_8"),
		        				res.getInt("Qpart3_9"),
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
}
