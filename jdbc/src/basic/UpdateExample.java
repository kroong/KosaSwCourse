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
			//���Ṯ�ڿ�(connection String) 1  ip, 2 port,3 db
			String sql="update boards set board_title=?,board_content=?,board_writer=? where board_no=?";
			//�Ű�����ȭ�� sql��
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "my");
			pstmt.setString(2, "life is java");
			pstmt.setString(3, "������");
			pstmt.setInt(4, 7);
			
			int rows=pstmt.executeUpdate();
			          //������ insert �Ǵ� ���� ��
			System.out.println(rows+"�Ѱ��� ���� �����");
			
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
