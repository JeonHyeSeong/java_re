package JDBC;

import java.util.List;
import java.util.Scanner;

public class ProductController {
	/* 상품등록, 상품리스트보기, 상품상세보기, 상품수정, 상품삭제
	 * Controller <- Service(interface) <- DAO(interface)
	 * Controller에서 모든 메뉴에 분기처리
	 * */
	private Scanner scan;
	private Service svc;
	private boolean flag; // 종료 변수
	
	public ProductController() {
		scan = new Scanner(System.in);
		svc = new ProductServiceImpl(); // service 구현 객체
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--상품관리 프로그램--");
			System.out.println("1. 상품등록 | 2. 상품목록 | 3. 상품검색(상품상세)");
			System.out.println("4. 상품수정 | 5. 상품삭제 | 6. 종료");
			System.out.print("메뉴 선택 > ");
			int menu = scan.nextInt();
			
			switch(menu) {
			case 1 : register();
				break;
			case 2 : list();
				break;
			case 3 : detail();
				break;
			case 4 : modify();
				break;
			case 5 : remove();
				break;
			default :
				flag = false;
				break;
			}
		}
		
	}
	
	/* select 리턴이 있음. Product 객체 리턴
	 * insert(등록), update(수정), delete(삭제)
	 * 리턴은 1개의 값이 실행되었습니다. => 1
	 * 실행이 안되었을때 => 0
	 * */

	private void remove() {
		System.out.print("삭제할 상품번호 > ");
		int pno = scan.nextInt();
		int isOk = svc.remove(pno);
		System.out.println("상품삭제 "+((isOk > 0)? "성공" : "실패"));
	}

	private void modify() {
		// pno에 해당하는 객체를 수정(pname, price, madeby)
		System.out.print("상품번호 > ");
		int pno = scan.nextInt();
		System.out.print("변경할 상품명 > ");
		scan.nextLine();
		String pname = scan.nextLine();
		System.out.print("변경할 상품가격 > ");
		int price = scan.nextInt();
		System.out.print("변경할 상품상세내용 > ");
		scan.nextLine();
		String madeby = scan.nextLine();
		Product p = new Product(pno, pname, price, madeby);
		int isOk = svc.modify(p);
		System.out.println("상품수정 "+((isOk > 0)? "성공" : "실패"));
	}

	private void detail() {
		// 상품 하나의 상세정보 select * from product where pno = ?
		System.out.print("상품번호 > ");
		int pno = scan.nextInt(); // 1
		Product p = svc.detail(pno);
		System.out.println(p);
	}

	private void list() {
		// 상품 전체 리스트 select * from product
		List<Product> list = svc.list();
		// 출력
		for(Product p : list) {
			System.out.println(p);
		}
	}

	private void register() {
		// 상품등록
		System.out.print("상품이름 > ");
		scan.nextLine();
		String pname = scan.nextLine();
		System.out.print("상품가격 > ");
		int price = scan.nextInt();
		System.out.print("상품상세내용 > ");
		scan.nextLine(); // 위쪽 공백처리
		String madeby = scan.nextLine();
		Product p = new Product(pname, price, madeby);
		// 서비스에게 등록을 요청하는 메서드 작성
		int isOk = svc.resister(p);
		// isOk : DB에서 insert되고난 후 리턴해주는 값
		// 잘되면 1을 리턴, 안되면 0을 리턴
		System.out.println("상품등록 "+((isOk > 0)? "성공" : "실패"));
	}
}
