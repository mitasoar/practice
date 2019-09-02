package level_1;

public class FinePrimeNum {

	public static void main(String[] args) {

	}

	public int solution(int n) {
		int answer = 1;

		for (int i = 3; i <= n; i += 2) {
			boolean b = true;
			for (int j = 3; j <= Math.sqrt(i); j += 2) {
				if (i % j != 0) {
					continue;
				} else if (i % j == 0) {
					b = false;
					break;
				}
			}
			if (b == true)
				answer++;
		}
		return answer;
	}
}
