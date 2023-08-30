package word;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Wordmanager {
	private ArrayList<Word> list = new ArrayList<>();
	
	
	public void insert(Scanner scan) {
		Word w = new Word();
		System.out.print("단어 입력 > ");
		w.setWord(scan.next());
		System.out.print("뜻 입력 > ");
		w.setMean(scan.next());
		list.add(w);
	}
	
	public void search(Scanner scan) {
		System.out.print("검색할 단어 입력 > ");
		String str = scan.next();
		for(int i = 0; i < list.size(); i++) {
			if(str.equals(list.get(i).getWord())) {
				System.out.println(list.get(i).getWord()+" : "+list.get(i).getMean());
			}
		}
	}
	
	public void update(Scanner scan) {
		System.out.print("수정할 단어 입력 > ");
		String str2 = scan.next();
		for(int i = 0; i < list.size(); i++) {
			if(str2.equals(list.get(i).getWord())) {
				System.out.print("바꿀 단어 입력 > ");
				String str3 = scan.next();
				list.get(i).setWord(str3);
				System.out.print("바꿀 뜻 입력 > ");
				String updateMean = scan.next();
				list.get(i).setMean(updateMean);
				System.out.println("수정완료");
				return;
			}
		}
		System.out.println("검색 단어가 없습니다.");
	}
	
	public void delete(Scanner scan) {
		System.out.print("삭제할 단어 입력 > ");
		String str4 = scan.next();
		for(int i = 0; i < list.size(); i++) {
			if(str4.equals(list.get(i).getWord())) {
				list.remove(i);
				System.out.println("삭제완료");
			}
		}
	}
	
	public void printWord() {
		for(Word tmp : list) {
			System.out.println(tmp); // toString 호출
		}
	}

	public void fileprint() throws IOException {
		// 파일로 출력
		FileWriter fw = new FileWriter("word.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		StringBuffer sb = new StringBuffer();
		
		String data = "";
		int cnt = 0;
		
		while(cnt < list.size()) { // 리스트가 모두 소진될때까지
			sb.append(list.get(cnt).toString());
			sb.append("\r\n"); // 줄바꿈
			data = sb.toString();
			cnt++;
		}
		System.out.println(data);
		fw.write(data);
		fw.close();
		bw.close();
	}
}
