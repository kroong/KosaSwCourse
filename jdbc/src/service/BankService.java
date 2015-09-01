package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionManager;

public class BankService {
	public void transfer(int from, int to, int amount) {
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			//Ʈ����� �۾� ����
			conn.setAutoCommit(false);
			
			AccountDao accountDao = new AccountDao(conn);
			//��� �۾�
			Account fromAccount = accountDao.selectByPk(from);
			Account toAccount = accountDao.selectByPk(to);
			//�Ա� �۾�
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			
			accountDao.update(fromAccount);
			accountDao.update(toAccount);
			conn.commit();
			System.out.println("���� ��ü ����");
		} catch (Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}System.out.println("���� ��ü ����");
		} finally {

			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}