package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl",
					"user0",
					"12345");
			//연결문자열(connection String) 1  ip, 2 port,3 db
			String sql="update boards set board_title=?,board_content=?,board_writer=? where board_no=?";
			//매개변수화된 sql문
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "my");
			pstmt.setString(2, "life is java");
			pstmt.setString(3, "이주헌");
			pstmt.setInt(4, 7);
			
			int rows=pstmt.executeUpdate();
			          //실제로 insert 되는 행의 수
			System.out.println(rows+"한개의 행이 저장됨");
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch(SQLException e){
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			try {
				
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

}
