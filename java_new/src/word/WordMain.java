package word;

import java.util.Scanner;

public class WordMain {

	public static void main(String[] args) {
		/* 단어장 프로그램 작성
		 * word 클래스 생성
		 * 단어, 의미
		 * 메뉴
		 * 1. 단어등록, 2. 단어검색, 3. 단어수정, 4. 단어출력 5. 종료
		 * 파일로 내보내기
		 * */
		Scanner scan = new Scanner(System.in);
		Wordmanager wm = new Wordmanager();
		
		int menu = 0;
		do {
			System.out.println("1. 단어등록 | 2. 단어검색 | 3. 단어수정 | 4. 단어출력 | 5. 단어삭제 | 6. 파일출력 | 7. 종료");
			System.out.print("메뉴를 선택하세요 > ");
			menu = scan.nextInt();
			try {
				switch(menu) {
				case 1 : wm.insert(scan); break;
				case 2 : wm.search(scan); break;
				case 3 : wm.update(scan); break;
				case 4 : wm.printWord(); break;
				case 5 : wm.delete(scan); break;
				case 6 : wm.fileprint(); break;
				case 7 : System.out.println("종료!"); break;
				default : 
					System.out.println("잘못된 메뉴 입니다.");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}while(menu != 7);
		

	}

}
