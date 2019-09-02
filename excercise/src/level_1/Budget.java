package level_1;

import java.util.Arrays;

public class Budget {

	public static void main(String[] args) {

	}

	public int solution(int[] d, int budget) {
		int answer = 0;

		int[] c = Arrays.copyOfRange(d, 0, d.length);

		Arrays.sort(c);

		for (int i = 0; i < c.length; i++) {
			if (budget > -1) {
				budget -= c[i];
				if (budget > -1) {
					answer++;
				} else {
					return answer;
				}
			} else {
				return answer;
			}
		}

		return answer;
	}

}
