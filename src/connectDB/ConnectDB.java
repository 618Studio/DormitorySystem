package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	private static ConnectDB instance;
	private static Connection conn;
	private static Statement statement;
	
	public static ConnectDB getInstance(){
		   return instance;
	}
	
	private ConnectDB() {
		// ����������
		String driver = "com.mysql.jdbc.Driver";
		// URLָ��Ҫ���ʵ����ݿ���
		String url = "jdbc:mysql://127.0.0.1:3306/DormitorySystem";
		// MySQL����ʱ���û���
		String user = "root";
		// MySQL����ʱ������
		String password = "apple";
		try {
			// ������������
			Class.forName(driver);
			// �������ݿ�
			conn = DriverManager.getConnection(url, user, password);
			if (!conn.isClosed())
				System.out.println("Succeeded connecting to the Database!");
			instance = new ConnectDB();
		} catch (Exception e) {
			System.out.print("Connected fail!");
			System.exit(1);
		}
	}
	
	private void closeDB(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void finalize()
    {
		try {
			statement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		instance.closeDB(); 
    }
	
	private static int update(String sql){
		int rs;
		try {
			// statement����ִ��SQL���
			statement = conn.createStatement();
			// Ҫִ�е�SQL���
			rs = statement.executeUpdate(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	private static ResultSet query(String sql) {
		ResultSet rs;
		try {
			// statement����ִ��SQL���
			statement = conn.createStatement();
			// Ҫִ�е�SQL���
			// �����
			rs = statement.executeQuery(sql);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*public static void main(String args[]){
	ConnectDB connect = new ConnectDB();
	String s = "2016-05-03 09:25:12";
	Timestamp time = Timestamp.valueOf(s);
	ChatMessage mes = new ChatMessage("1", "10000", "10001", s, "helloworld!");
	System.out.println(connect.saveMessage(mes));
	Account a = new Account("10000",null,null);
	getFriend(a);
}*/
	
}