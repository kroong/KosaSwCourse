package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ConnectionManager;

public class BankService {
	public void transfer(int from, int to, int amount) {
		Connection conn = null;

		try {
			conn = ConnectionManager.getConnection();
			//트랜잭션 작업 시작
			conn.setAutoCommit(false);
			
			AccountDao accountDao = new AccountDao(conn);
			//출금 작업
			Account fromAccount = accountDao.selectByPk(from);
			Account toAccount = accountDao.selectByPk(to);
			//입금 작업
			fromAccount.setBalance(fromAccount.getBalance() - amount);
			toAccount.setBalance(toAccount.getBalance() + amount);
			
			accountDao.update(fromAccount);
			accountDao.update(toAccount);
			conn.commit();
			System.out.println("계좌 이체 성공");
		} catch (Exception e){
			try {
				conn.rollback();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}System.out.println("계좌 이체 실패");
		} finally {

			try {
				conn.close();
			} catch (Exception e) {
			}
		}
	}
}