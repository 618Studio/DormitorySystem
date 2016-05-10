package connectDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectDB {
	private static ConnectDB instance = new ConnectDB();
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
	
	protected static int update(String sql){
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
	
	protected static ResultSet query(String sql) {
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
}