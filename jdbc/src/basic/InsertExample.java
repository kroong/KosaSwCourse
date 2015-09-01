package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://blueskii.iptime.org:3306/team2",
					"team2",
					"123456");
			//���Ṯ�ڿ�(connection String) 1  ip, 2 port,3 db
			String sql="insert into boards(board_title, board_content,board_writer,board_date) values(?,?,?,now())";
			//�Ű�����ȭ�� sql��
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "������ ȭ����");
			pstmt.setString(2, "������ 10�ñ���?");
			pstmt.setString(3, "ȫ�浿");
			int row = pstmt.executeUpdate();
			          //������ insert �Ǵ� ���� ��
			
			
			
			System.out.println("�Ѱ��� ���� �����");
			
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