package boardJDBC;

import java.util.List;

public class BoardServiceImpl implements Service {
	
	private DAO dao;
	
	public BoardServiceImpl() {
		dao = new BoardDAOImpl();
	}

	@Override
	public int register(BoardVO b) {
		System.out.println("resister_service success!!");
		return dao.insert(b);
	}

	@Override
	public List<BoardVO> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public BoardVO detail(int bno) {
		int isOk = dao.readCount(bno);
		System.out.println("detail_service success!!");
		return (isOk>0)? dao.selectOne(bno) : null;
	}

	@Override
	public int modify(BoardVO b) {
		System.out.println("modify_service success!!");
		return dao.update(b);
	}

	@Override
	public int remove(int bno) {
		System.out.println("remove_service success!!");
		return dao.delete(bno);
	}
}
