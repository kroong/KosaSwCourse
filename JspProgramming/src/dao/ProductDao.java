package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Product;


public class ProductDao {
	private Connection conn;

	public ProductDao(Connection conn) {
		this.conn = conn;
	}

	public Integer insert(Product product) throws SQLException {
		Integer pk = null;
		String sql = "insert into Team2_products (product_name, product_price, product_stock, product_detail) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "product_no" });
		pstmt.setString(1, product.getName());
		pstmt.setInt(2, product.getPrice());
		pstmt.setInt(3, product.getStock());
		pstmt.setString(4, product.getDetail());
		
		int rows = pstmt.executeUpdate();
		if (rows == 1) {
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) {
				pk = rs.getInt(1);
			}
			rs.close();
		}
		pstmt.close();
		return pk;
	}

	public List<Product> selectByPage(int pageNo, int rowsPerPage) throws SQLException {
		List<Product> list = new ArrayList<Product>();
		String sql = "";
		sql += "select product_no, product_name, product_price, product_stock, product_detail ";
		sql += "from Team2_products ";
		sql += "order by product_no desc ";
		sql += "limit ?,?";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, (pageNo - 1) * rowsPerPage);
		pstmt.setInt(2, rowsPerPage);

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			// false를 리턴하면 뒤에 행이 없는 것.
			Product product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setStock(rs.getInt("product_stock"));
			product.setDetail(rs.getString("product_detail"));
			list.add(product);
		}
		rs.close();
		pstmt.close();

		return list;
	}

	public Product selectByPk(int productNo) throws SQLException {
		Product product = null;
		String sql = "select * from Team2_products where product_no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productNo);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {

			// false를 리턴하면 뒤에 행이 없는 것.
			product = new Product();
			product.setNo(rs.getInt("product_no"));
			product.setName(rs.getString("product_name"));
			product.setPrice(rs.getInt("product_price"));
			product.setStock(rs.getInt("product_stock"));
			product.setDetail(rs.getString("product_detail"));

		}
		rs.close();
		pstmt.close();

		return product;
	}

	public int update(Product product) throws SQLException {
		int rows = 0;
		String sql = "update Team2_products set product_name=?, product_price=?, product_stock=?, product_detail=? where product_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, product.getName());
		pstmt.setInt(2, product.getPrice());
		pstmt.setInt(3, product.getStock());
		pstmt.setString(4, product.getDetail());
		pstmt.setInt(5, product.getNo());

		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}

	public int delete(int productNo) throws SQLException {
		int rows = 0;
		String sql = "delete from Team2_products where product_no = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, productNo);
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}

	public int updateHitcount(long productNo) throws SQLException {
		int rows = 0;
		String sql = "update Team2_products set product_hitcount=product_hitcount+1 where product_no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, productNo);
		rows = pstmt.executeUpdate();
		pstmt.close();
		return rows;
	}

	public int selectCount() throws SQLException {
		int rows = 0;
		String sql = "select count(*) from Team2_products";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			rows = rs.getInt(1);
		}
		rs.close();
		pstmt.close();

		return rows;
	}
}
