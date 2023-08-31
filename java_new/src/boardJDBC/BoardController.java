package boardJDBC;

import java.util.List;
import java.util.Scanner;

public class BoardController {
	private Scanner scan;
	private Service svc;
	private boolean flag;
	
	public BoardController() {
		scan = new Scanner(System.in);
		svc = new BoardServiceImpl();
		flag = true;
		printMenu();
	}

	private void printMenu() {
		while(flag) {
			System.out.println("--게시판--");
			System.out.println("1. 게시글 등록 | 2. 게시글 목록 | 3. 게시글 조회");
			System.out.println("4. 게시글 수정 | 5. 게시글 삭제 | 6. 종료");
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

	private void register() {
		System.out.print("제목 > ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("작성자 > ");
		String writer = scan.next();
		System.out.print("내용 > ");
		scan.nextLine();
		String content = scan.nextLine();
		BoardVO b = new BoardVO(title, writer, content);
		int isOk = svc.register(b);
		System.out.println("게시글 등록 "+((isOk > 0)? "성공" : "실패"));
	}

	private void list() {
		List<BoardVO> list = svc.list();
		
		for(BoardVO b : list) {
			System.out.println(b);
		}
	}

	private void detail() {
		System.out.print("게시글 번호 > ");
		int bno = scan.nextInt();
		BoardVO b = svc.detail(bno);
		b.printDetail();
	}

	private void modify() {
		System.out.print("게시글 번호 > ");
		int bno = scan.nextInt();
		System.out.print("수정할 제목 > ");
		scan.nextLine();
		String title = scan.nextLine();
		System.out.print("작성자 수정 > ");
		String writer = scan.next();
		System.out.print("수정할 내용 > ");
		scan.nextLine();
		String content = scan.nextLine();
		BoardVO b = new BoardVO(bno, title, writer, content);
		int isOk = svc.modify(b);
		System.out.println("게시글 수정 "+((isOk > 0)? "성공" : "실패"));
	}

	private void remove() {
		System.out.print("삭제할 게시글 번호 > ");
		int bno = scan.nextInt();
		int isOk = svc.remove(bno);
		System.out.println("게시글 삭제 "+((isOk > 0)? "성공" : "실패"));
	}
}
