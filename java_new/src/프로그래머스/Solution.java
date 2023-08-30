package 프로그래머스;

public class Solution {
	public String solution(String my_string, int n) {
		/* 문자열 my_string과 정수 n이 매개변수로 주어질 때, 
		 * my_string에 들어있는 각 문자를 n만큼 반복한 문자열을 return 하도록 solution 함수를 완성해보세요.
		 * "hello"	 3	"hhheeellllllooo"
		 * */
        String answer = "";
        
        for(int i = 0; i < my_string.length(); i++) {
        	char temp = my_string.charAt(i);
        	String str = String.valueOf(temp);
        	for(int j=0; j<n; j++) {
        		answer+=str;
        	}
        	
        }
        
        return answer;
    }

}
