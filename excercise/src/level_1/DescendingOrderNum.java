package level_1;

import java.util.Arrays;

public class DescendingOrderNum {

	public static void main(String[] args) {
		
		long a = 42810571895l;
		
		System.out.println(solution(a));
		
	}

	public static long solution(long n) {
		long answer = 0;

		String a = Long.toString(n);

		String b = new String();

		String[] c = a.split("");

		Arrays.sort(c);

		for (int i = c.length - 1; i > -1; i--) {
			b += c[i];
		}
		
		answer = Long.parseLong(b);

		return answer;
	}

}
