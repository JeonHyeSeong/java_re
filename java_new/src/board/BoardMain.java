package board;

import java.util.Scanner;

public class BoardMain {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		BoardManager bm = new BoardManager();
		
		int menu = 0;
		do {
			System.out.println("1.게시글 등록 | 2. 게시글 조회 | 3. 게시글 수정");
			System.out.println("4.게시글 삭제 | 5. 게시글 목록보기 | 6. 종료");
			System.out.print("메뉴 선택 > ");
			menu = scan.nextInt();
			switch(menu) {
			case 1 : bm.addBoard(scan); break;
			case 2 : bm.searchBoard(scan); break;
			case 3 : bm.modifyBoard(scan); break;
			case 4 : bm.removeBoard(scan); break;
			case 5 : bm.printBoard(); break;
			case 6 : System.out.println("프로그램 종료!"); break;
			default : 
				System.out.println("잘못된 메뉴 입니다.");
			}
			
		}while(menu != 6);

	}

}
