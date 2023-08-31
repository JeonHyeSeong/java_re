package boardJDBC;

import java.util.List;

public interface Service {

	int register(BoardVO b);

	List<BoardVO> list();

	BoardVO detail(int bno);

	int modify(BoardVO b);

	int remove(int bno);

}
