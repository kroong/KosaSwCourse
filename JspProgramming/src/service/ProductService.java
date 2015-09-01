package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.ConnectionManager;
import dto.Product;

public class ProductService {
	public void add(Product product) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.insert(product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	public List<Product> getPage(int pageNo, int rowsPerPage) {
		List<Product> list = new ArrayList<Product>();
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			list = ProductDao.selectByPage(pageNo, rowsPerPage);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return list;
	}

	public Product getProduct(int ProductNo) {
		Product Product = null;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			Product = ProductDao.selectByPk(ProductNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return Product;
	}

	public void modify(Product Product) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.update(Product);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	public void remove (int ProductNo) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.delete(ProductNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
	
	/*public void addHitcount(long ProductNo) {
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			ProductDao.updateHitcount(ProductNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}*/
	
	//페이징 관련 필드와 메소드--------------------------------------------
	private int rowsPerPage = 10;
	private int pagesPerGroup = 3;

	public int getRowsPerPage() {
		return rowsPerPage;
	}
	
	public int getGroupNo(int pageNo) {
		return (pageNo-1)/pagesPerGroup +1;
		//int끼리 계산하면 내림
	}
	
	public int getStartPageNo(int groupNo) {
		return (groupNo-1) * pagesPerGroup +1;
	}
	public int getEndPageNo(int groupNo) {
		return getStartPageNo(groupNo) + pagesPerGroup + 1;
	}
	
	public int getTotalPageNo() {
		int totalPageNo = 1;
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			ProductDao ProductDao = new ProductDao(conn);
			int rows = ProductDao.selectCount(); 
			totalPageNo = rows / rowsPerPage;
			if (rows%rowsPerPage != 0) {
				totalPageNo++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {}
		}
		return totalPageNo;
	}
	public int getTotalGroupNo() {
		int totalPageNo = getTotalPageNo();
		int totalGroupNo = getTotalPageNo() / pagesPerGroup;
		if(totalPageNo%pagesPerGroup != 0) {
			totalGroupNo ++;
		}
		return totalGroupNo;
		
	}
}
