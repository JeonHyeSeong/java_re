package board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Board{
	private int num;
	private String title;
	private String content;
	private String name;
	private String strDay;
	
	public Board() {
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) HH:mm:ss");
		strDay = sdf.format(now);
	}
	
	public Board(int num ,String title, String content, String name) {
		this.num = num;
		this.title = title;
		this.content = content;
		this.name = name;
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일(E) HH:mm:ss");
		strDay = sdf.format(now);
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDay() {
		return strDay;
	}

	public void setDay(String strDay) {
		this.strDay = strDay;
	}

	@Override
	public String toString() {
		return "[번호 : " +num+", 제목 : "+title+"]";
	}
	
	

}
