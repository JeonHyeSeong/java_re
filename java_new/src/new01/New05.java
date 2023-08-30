package new01;

import java.util.HashMap;
import java.util.Scanner;

public class New05 {

	public static void main(String[] args) {
		/* New04의 내용을 메서드로 분리
		 * */
		// map을 받아서 출력
		Scanner scan = new Scanner(System.in);
		HashMap<String, String> map = wordmap(scan);
		
		for(String tmp : map.keySet()) {
			System.out.println(tmp+" : "+map.get(tmp));
		}

	}
	
	/* 기능 => 단어 : 의미를 입력받아서 map을 구성
	 * 리턴 : map
	 * 매개변수 : X
	 * */
	public static HashMap<String,String> wordmap(Scanner scan) {
		HashMap<String,String> map = new HashMap<>();
		
		
		System.out.print("입력받을 단어 개수 > ");
		int num = scan.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.print("단어 입력 > ");
			String word = scan.next();
			System.out.print("뜻 입력 > ");
			String mean = scan.next();
			map.put(word, mean);
		}
		

		return map;
	}

}
