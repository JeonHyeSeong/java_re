package JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements DAO {

	// DB 연결
	private Connection conn;
	
	// sql 구문을 실행시키는 기능을 갖는 객체
	private PreparedStatement pst;
	private String query=""; // 쿼리 구문 저장
	
	public ProductDAOImpl() {
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}
	
	// SQL 구문 처리
	
	
	@Override
	public int insert(Product p) {
		System.out.println("insert DAO success!!");
		query="insert into product (pname, price, madeby) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			// insert, update, delete => executeUpdate() return int
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Product> selectList() {
		System.out.println("list DAO success!!");
		query = "select * from product order by pno desc";
		List<Product> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				// pno, pname, price
				list.add(new Product(
						rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("selectList Error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Product selectOne(int pno) {
		System.out.println("detail_DAO success!!");
		query = "select * from product where pno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt("pno"),
						rs.getString("pname"),
						rs.getInt("price"),
						rs.getString("regdate"),
						rs.getString("madeby"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne Error!!");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int update(Product p) {
		System.out.println("modify_DAO success!!");
		query = "update product set pname=?,price=?,regdate=now(),madeby=? where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getPrice());
			pst.setString(3, p.getMadeby());
			pst.setInt(4, p.getPno());
			return pst.executeUpdate();
		} catch (SQLException e) {
			// conn연결 오류, SQL 구문 오류
			System.out.println("update Error!!");
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(int pno) {
		System.out.println("remove_DAO success!!");
		query = "delete from product where pno=?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, pno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete Error!!");
			e.printStackTrace();
		}
		return 0;
	}

}
