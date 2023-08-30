package new02;

public class SingletonMain {

	public static void main(String[] args) {
		// 싱글톤의 객체 생성
//		Singleton s = new Singleton(); // 생성 X
		Singleton s = Singleton.getInstance(); // 클래스명.메서드명()
		Singleton s2 = Singleton.getInstance();
		
		if(s == s2) { // 주소가 같은지 보는 것
			System.out.println("s == s2는 같은 객체");
		}else {
			System.out.println("s != s2는 다른 객체");
		}

	}

}
