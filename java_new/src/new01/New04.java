package new01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class New04 {

	public static void main(String[] args) {
		/* 단어장
		 * 단어 : 의미
		 * map으로 생성
		 * 입력받을 단어의 개수를 받아서 그만큼 map에 추가
		 * 콘솔에 찍기
		 * */
		
		HashMap<String, String> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("입력받을 단어 개수 > ");
		int num = scan.nextInt();
		
		for(int i = 1; i <= num; i++) {
			System.out.println("단어 입력 > ");
			String word = scan.next();
			System.out.println("뜻 입력 > ");
			String mean = scan.next();
			map.put(word, mean);
		}
		
		
		for(String tmp : map.keySet()) {
			System.out.println(tmp+" : "+map.get(tmp));
		}
		
		Iterator<String> it = map.keySet().iterator();
		
		while(it.hasNext()) {
			String word = it.next();
			System.out.println(word+" : "+map.get(word));
		}
		
		
		
		
		scan.close();

	}

}
