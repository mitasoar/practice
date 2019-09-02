package level_1;

import java.util.Arrays;

public class ReverseNum {

	public static void main(String[] args) {

		long a = 123456789;
		
		System.out.println(Arrays.toString(solution(a)));
		
	}

	public static int[] solution(long n) {
		
		String s = String.valueOf(n);
		
		char[] ch = s.toCharArray();
		
		int[] answer = new int [ch.length];
		
		int a = 0;
		
		for (int i = ch.length - 1; i > -1; i--) {
			answer[a] = (int)ch[i] - 48;
			a++;
		}
		
		return answer;
	}
}
