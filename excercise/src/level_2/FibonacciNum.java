package level_2;

public class FibonacciNum {
	
	public static void main(String[] mita) {
		System.out.println(solution(6));
		
		String[] strs = null;
		
		for (String str : strs) {
			System.out.println(str);
		}
	}
	
	public static int solution(int n) {
		long answer = 0;
		
		long a = 0;
		long b = 1;
		
		for (int i = 2; i <= n; i++) {
			a %= 1234567;
			b %= 1234567;
			answer = a + b;
			a = b;
			b = answer;
		}
		
		return (int)(answer % 1234567);
	}
}
