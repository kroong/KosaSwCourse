package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionExample {

	public static void main(String[] args) {
		Connection conn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2",
					"team2",
					"123456");
			//연결문자열(connection String) 1  ip, 2 port,3 db
			System.out.println("연결 성공");
			
		} catch (ClassNotFoundException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
