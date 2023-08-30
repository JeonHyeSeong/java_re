package new02;

import java.util.Calendar;

public class SingletonCount {

	public static void main(String[] args) {
		// 객체를 2개 생성
		// 각각 객체에서 countMethod 실행
		// 출력
		Counter c = Counter.getInstance();
		Counter c2 = Counter.getInstance();
		
		System.out.println(c.countMethod());
		System.out.println(c2.countMethod());
		
		Calendar ca = Calendar.getInstance();
		int year = ca.get(Calendar.YEAR);
		System.out.println(year);

	}

}

class Counter{
	// 싱글톤으로 객체 만들기
	private static Counter instance;
	private int count;
	
	// private 생성자
	private Counter() {}
	// getInstance()
	public static Counter getInstance() {
		if(instance == null) {
			instance = new Counter();
		}
		return instance;
	}
	
	// count()  // 멤버변수의 count가 1씩 증가
	public int countMethod() {
		count++;
		return count;
	}
}
