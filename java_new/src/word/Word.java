package word;

/* 단어장 프로그램 작성
 * word 클래스 생성
 * 단어, 의미
 * 메뉴
 * 1. 단어등록, 2. 단어검색, 3. 단어수정, 4. 단어출력 5. 종료
 * 
 * */
public class Word {
	private String word;
	private String mean;
	
	public Word() {
		
	}

	public Word(String word, String mean) {
		this.word = word;
		this.mean = mean;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public String getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean = mean;
	}

	@Override
	public String toString() {
		return word + " : " + mean;
	}
	
	

}
