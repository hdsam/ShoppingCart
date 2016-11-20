package dbUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

//单例模式创建一个数据库连接工厂类工具类
public class DBConnectionFactory {
	private static String driver;
	private static String dburl;
	private static String user;
	private static String pwd;
	private static DBConnectionFactory factory = new DBConnectionFactory();
	private static Connection conn=null;

	//读取数据库配置文件
	static {
		Properties prop = new Properties();
		try {
			InputStream in = DBConnectionFactory.class.getClassLoader()
					.getResourceAsStream("dbconfig.properties");
			prop.load(in);
		} catch (IOException e) {
			System.out.println("属性文件读取错误");
			e.printStackTrace();
		}
		driver = prop.getProperty("driver");
		dburl = prop.getProperty("dburl");
		user = prop.getProperty("user");
		pwd = prop.getProperty("pwd");
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动注册失败！！");
			e.printStackTrace();
		}
	}

	private DBConnectionFactory() {};

	public static DBConnectionFactory getInstance() {
		return factory;
	}

	//获得数据库连接
	public Connection getConnection() {
			try {
				if(conn==null || conn.isClosed())
				conn = DriverManager.getConnection(dburl, user, pwd);
			} catch (SQLException e) {
				System.out.println("获取数据库连接失败！！");
				e.printStackTrace();
			}
		
		return conn;
	}
	
	//关闭数据库连接
	public void closeConnection(Connection conn,PreparedStatement pst,ResultSet rs){
			try {
				if(conn!=null) conn.close();
				if(pst!=null) pst.close();
				if(pst!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
}
