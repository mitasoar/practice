package level_2;

import java.util.Arrays;

public class FunctionalDevelopment {

	public static int[] solution(int[] progresses, int[] speeds) {

		int[] answer = {};
		int[] com = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++) {
			int n = 0;
			while (progresses[i] < 100) {
				progresses[i] += speeds[i];
				n++;
			}
			com[i] = n;
		}

		for (int i = 0; i < com.length; i++) {
			if (com[i] > 0) {
				int c = 1;
				if (i != com.length - 1) {
					for (int j = i + 1; j < com.length; j++) {
						if (com[j] > 0) {
							if (com[i] >= com[j]) {
								c++;
								com[j] = -1;
							} else {
								i = j - 1;
								break;
							}
						}
					}
				}
				answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
				answer[answer.length - 1] = c;
				if (c == com.length)
					break;
			}
		}
		return answer;
	}
}
