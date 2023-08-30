package JDBC;

import java.util.List;

public interface Service {

	int resister(Product p);

	List<Product> list();

	Product detail(int pno);

}
