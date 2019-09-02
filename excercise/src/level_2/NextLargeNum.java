package level_2;

public class NextLargeNum {

	public static int solution(int n) {
		int answer = n + 1;
		
		int one = Integer.toBinaryString(n).replaceAll("[^1]", "").length();
		
		while (true) {
			if (one == Integer.toBinaryString(answer).replaceAll("[^1]", "").length()) return answer;
			answer++;
		}
	}
}
