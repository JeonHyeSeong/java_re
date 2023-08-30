package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	// DB 접속
	// DB Driver, Url, user, password
	// com.mysql.cj.jdbc.Driver
	// jdbc:mysql://localhost:3306/db명
	
	private static DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = null;
	private String jdbcDriver = "com.mysql.cj.jdbc.Driver";
	private String jdbcUrl = "jdbc:mysql://localhost:3306/productdb";
	
	// 생성자를 private로 생성
	private DatabaseConnection() {
		// DB연결시 반드시 try~catch를 사용해야 함.
		try {
			Class.forName(jdbcDriver); // 드라이버를 로드하기 위해 사용되는 메서드
			conn = DriverManager.getConnection(jdbcUrl, "mysqluser", "mysql"); // url 연결 메서드 url, user, password
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버를 찾을 수 없습니다.");
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println("연결정보가 정확하지 않습니다.");
			e.printStackTrace();
		}
	}
	
	public static DatabaseConnection getInstance() {
		return dbc;
	}
	
	public Connection getConnection() {
		return conn;
	}
}







