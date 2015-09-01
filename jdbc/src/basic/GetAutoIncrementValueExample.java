package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2",
					"team2",
					"123456");
			//연결문자열(connection String) 1  ip, 2 port,3 db
			String sql="insert into boards(board_title, board_content,board_writer,board_date) values(?,?,?,now())";
			//매개변수화된 sql문
			pstmt = conn.prepareStatement(sql,new String[]{"board_no"});
			
			pstmt.setString(1, "오늘은 화요일");
			pstmt.setString(2, "오늘은 10시까지?");
			pstmt.setString(3, "홍길동");
			int row = pstmt.executeUpdate();
			          //실제로 insert 되는 행의 수
			int boardNo=0;
			
			if(row==1){
				ResultSet rs=pstmt.getGeneratedKeys();
				if(rs.next()){
					boardNo = rs.getInt(1);
				}
				rs.close();
			}
			
			
			System.out.println(boardNo +"번 게시물이 저장됨");
			
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
