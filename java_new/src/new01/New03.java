package new01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class New03 {

	public static void main(String[] args) {
		/* 컬렉션 프레임워크
		 * - List : 순서를 보장, 중복저장 가능
		 * - Set : 순서보장X, 중복X
		 * - Map : 2가지 데이터를 쌍으로 저장, 순서보장X
		 * 	- key(중복불가능), value(중복가능)
		 * */
		
		// 리스트 생성하고, 1~10까지 등록한 후 출력
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 1; i <= 10; i++) {
			list.add(i);
		}
		System.out.println(list);
		
		for(Integer tmp : list) {
			System.out.print(tmp + " ");
		}
		System.out.println();
		
		// 정수를 입력받아서 입력받은 만큼 오늘의 할일을 입력하고 출력
		// 기존 리스트를 비우고 입력받기
		Scanner scan = new Scanner(System.in);
//		ArrayList<String> list2 = new ArrayList<>();
//		
//		System.out.print("정수 입력 > ");
//		int num = scan.nextInt();
//		
//		System.out.println("오늘의 할일 > ");
//		
//		for(int i = 1; i <= num; i++) {
//			String str = scan.next();
//			list2.add(str);
//		}
//		System.out.println(list2);
		
//		while(list2.size() < num) {
//			System.out.println(num+"개 오늘의 할일 > ");
//			String str = scan.next();
//			list2.add(str);
//		}
//		System.out.println(list2);
		
		/* map을 이용하여 이름 : 점수 형태로 3명만 입력
		 * 출력
		 * */
		HashMap<String, Integer> map = new HashMap<>();
		
		
		for(int i = 1; i <= 3; i++) {
			System.out.print("이름 입력 > ");
			String name = scan.next();
			System.out.print("점수 입력 > ");
			int score = scan.nextInt();
			map.put(name, score);
		}
		System.out.println(map);
		
		for(String tmp : map.keySet()) {
			System.out.println(tmp+" : "+map.get(tmp));
		}
		
		
		
		scan.close();

	}

}
