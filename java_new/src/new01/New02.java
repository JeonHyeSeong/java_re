package new01;

import java.util.Scanner;

public class New02 {

	public static void main(String[] args) {
		/* for문을 이용하여 1~10까지 중 짝수만 출력
		 * 1부터 내가 입력한 수까지 5의 배수를 출력
		 * */
		Scanner scan = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
		}
		
		System.out.println();
		System.out.print("숫자를 입력하세요 : ");
		int num = scan.nextInt();
		
		for(int i = 1; i <= num; i++) {
			if(i % 5 == 0) {
				System.out.print(i + " ");
			}
		}
		
		
		
		scan.close();

	}

}
