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
	
	protected static ResultSet query(String sql) {
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
}