package dao;

import java.sql.Connection;

public class BoardDaoSelectTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setNo(34);
		board.setTitle("������ DAO�� �մϴ�.");
		board.setContent("DAO�� �� �����!! ����� �����!!!");
		board.setWriter("�����");
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		if(rows==1){
			System.out.println(board.getNo()+"�� �Խù��� ������");
		}else{
			System.out.println(board.getNo()+"�� �Խù��� �������� �ʽ��ϴ�.");
		}
	}

}
