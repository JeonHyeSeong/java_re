package new01;

//import java.util.logging.Logger;

public class New01 {

//	private final static Logger LOG = Logger.getGlobal();

	public static void main(String[] args) {
		/* 홍길동 주민등록번호는 881122-1234567이다.
		 * 출력형태 => 생년월일 : 881122, 성별 : 남
		 * */
		
		String pin = "881122-1234567";
		String birth = pin.substring(0, pin.indexOf("-"));
//		String sub = pin.substring(7, 8);
		char ch = pin.charAt(pin.indexOf("-")+1);
		
		System.out.println("생년월일 : "+birth);
		
		if(ch == '1' || ch == '3') {
			System.out.println("성별 : 남");
		}else if(ch == '2' || ch == '4'){
			System.out.println("성별 : 여");
		}
		
		
//		LOG.info("생년월일 : "+pin.substring(0, 6));

	}

}
