package boardJDBC;

import java.util.List;

public interface DAO {

	int insert(BoardVO b);

	List<BoardVO> selectList();

	BoardVO selectOne(int bno);

	int update(BoardVO b);

	int delete(int bno);

	int readCount(int bno);

}
