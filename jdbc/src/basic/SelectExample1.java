package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample1 {

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
			String sql="select * from boards where board_no=?";
			//매개변수화된 sql문
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, 3);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
			
				int boardNo = rs.getInt("board_no");
			
				String boardTitle=rs.getString("board_title");
				String boardContent =rs.getString("board_content");
				Date boardDate=rs.getDate("board_Date");
				String boardWriter=rs.getString("board_writer");
				int boardHitcount=rs.getInt("board_hitcount");
				System.out.println(boardNo+"\t"+boardTitle+"\t"+boardDate+"\t"+boardWriter+"\t"+boardHitcount);
			}
			rs.close();
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
