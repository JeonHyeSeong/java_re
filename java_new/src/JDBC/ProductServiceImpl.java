package JDBC;

import java.util.List;

public class ProductServiceImpl implements Service {
	
	private DAO dao;
	
	public ProductServiceImpl() {
		dao = new ProductDAOImpl(); // 구현체
	}

	@Override
	public int resister(Product p) {
		// 실제 구현 영역
		System.out.println("resister_service success!!");
		// dao에서 사용되는 메서드명은 DB 구문과 비슷하게 하는 것이 일반적
		return dao.insert(p);
	}

	@Override
	public List<Product> list() {
		System.out.println("list_service success!!");
		return dao.selectList();
	}

	@Override
	public Product detail(int pno) {
		System.out.println("detail_service success!!");
		return dao.selectOne(pno);
	}

}
