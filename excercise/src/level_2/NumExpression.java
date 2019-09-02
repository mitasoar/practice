package level_2;

public class NumExpression {
	
	public static void main(String[] mita) {
		System.out.println(solution(3));
	}
	
	public static int solution(int n) {
		int answer = 1;
		
		if (n == 1) return answer;
		if (n % 2 == 1) answer++;
		for (int i = 3; i < n; i += 2) {
			if (n % i == 0) answer++;
		}
		
		return answer;
	}
}
