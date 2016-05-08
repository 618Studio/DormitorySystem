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
		// 驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		// URL指向要访问的数据库名
		String url = "jdbc:mysql://127.0.0.1:3306/DormitorySystem";
		// MySQL配置时的用户名
		String user = "root";
		// MySQL配置时的密码
		String password = "apple";
		try {
			// 加载驱动程序
			Class.forName(driver);
			// 连接数据库
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
			// statement用来执行SQL语句
			statement = conn.createStatement();
			// 要执行的SQL语句
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
			// statement用来执行SQL语句
			statement = conn.createStatement();
			// 要执行的SQL语句
			// 结果集
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