package board;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardManager implements BoardInterface{
	private ArrayList<Board> list = new ArrayList<>();
	private int num = 1;

	@Override
	public void addBoard(Scanner scan) {
		// 게시글 등록
		Board b = new Board();
		b.setNum(num++);
		System.out.print("제목 입력 > ");
		b.setTitle(scan.next());
		System.out.print("내용 입력 > ");
		b.setContent(scan.next());
		System.out.print("작성자 입력 > ");
		b.setName(scan.next());
		list.add(b);
		System.out.println("게시글이 등록되었습니다.");
	}

	@Override
	public void searchBoard(Scanner scan) {
		// 게시글 조회
		System.out.print("조회할 게시글 번호 > ");
		int num1 = scan.nextInt();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum() == num1) {
				System.out.println("번호 : "+list.get(i).getNum()+", 제목 : "+list.get(i).getTitle());
				System.out.println("내용 : "+list.get(i).getContent()+", 작성자 : "+list.get(i).getName()+", 작성일 : "+list.get(i).getDay());
				return;
			}
		}
		System.out.println("없는 번호입니다.");
	}

	@Override
	public void modifyBoard(Scanner scan) {
		// 게시글 수정
		System.out.print("수정할 게시글 번호 > ");
		int num2 = scan.nextInt();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum() == num2) {
				System.out.print("수정할 제목 > ");
				String motitle = scan.next();
				list.get(i).setTitle(motitle);
				System.out.print("수정할 내용 > ");
				String mocontent = scan.next();
				list.get(i).setContent(mocontent);
				System.out.println("수정완료!");
				return;
			}
		}
		System.out.println("없는 번호입니다.");
	}

	@Override
	public void removeBoard(Scanner scan) {
		// 게시글 삭제
		System.out.print("삭제할 게시글 번호 > ");
		int num3 = scan.nextInt();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getNum() == num3) {
				list.remove(i);
				System.out.println("삭제완료!");
				return;
			}
		}
		System.out.println("없는 번호입니다.");
	}

	@Override
	public void printBoard() {
		// 게시글 목록보기
		for(Board tmp : list) {
			System.out.println(tmp);
		}
	}

}
