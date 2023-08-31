package boardJDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements DAO{
	
	// DB 연결
	private Connection conn;
	private PreparedStatement pst;
	private String query="";
	
	public BoardDAOImpl() {
		// 데이터베이스 객체 생성
		DatabaseConnection dbc = DatabaseConnection.getInstance();
		conn = dbc.getConnection();
	}

	
	// 메서드 처리

	@Override
	public int insert(BoardVO b) {
		System.out.println("insert DAO success!!");
		query = "insert into board (title,writer,content) values(?,?,?)";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("insert Error!!");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public List<BoardVO> selectList() {
		System.out.println("list DAO success!!");
		query = "select * from board order by bno desc";
		List<BoardVO> list = new ArrayList<>();
		try {
			pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				list.add(new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("regdate"),
						rs.getInt("readcount")));
			}
			return list;
		} catch (SQLException e) {
			System.out.println("selectList Error!!");
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public BoardVO selectOne(int bno) {
		System.out.println("detail_DAO success!!");
		query = "select * from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				return new BoardVO(
						rs.getInt("bno"),
						rs.getString("title"),
						rs.getString("writer"),
						rs.getString("content"),
						rs.getString("regdate"),
						rs.getString("moddate"),
						rs.getInt("readcount"));
			}
		} catch (SQLException e) {
			System.out.println("selectOne Error!!");
			e.printStackTrace();
		}
		return null;
	}
	

	@Override
	public int update(BoardVO b) {
		System.out.println("update_DAO success!!");
		query = "update board set title=?,writer=?,content=?,moddate=now() where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setString(1, b.getTitle());
			pst.setString(2, b.getWriter());
			pst.setString(3, b.getContent());
			pst.setInt(4, b.getBno());
			return pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("update Error!!");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int delete(int bno) {
		System.out.println("delete_DAO success!!");
		query = "delete from board where bno = ?";
		try {
			pst = conn.prepareStatement(query);
			pst.setInt(1, bno);
			return pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("delete Error!!");
			e.printStackTrace();
		}
		return 0;
	}


	@Override
	public int readCount(int bno) {
		query = "update board set readcount = readcount + 1 where bno = ?";
	    try {
	        pst = conn.prepareStatement(query);
	        pst.setInt(1, bno);
	        return pst.executeUpdate();
	    } catch (SQLException e) {
	        System.out.println("ReadCount Error!!");
	        e.printStackTrace();
	    }
		return 0;
	}
	
}
