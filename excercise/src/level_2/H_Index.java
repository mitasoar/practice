package level_2;

import java.util.Arrays;

public class H_Index {
	
	public static int solution(int[] citations) {
		int answer = 0;
		
		for (int a : citations) {
			answer += a;
		}
		
		answer = answer / citations.length;
		
		Arrays.sort(citations);
		
		while (true) {
			if (answer == 0) {
				return answer;
			}
			
			if (answer > citations.length) {
				answer--;
				continue;
			} else {
				if (answer > citations[citations.length - answer]) {
					answer--;
					continue;
				} else if (answer <= citations[citations.length - answer]) {
					return answer;
				}
			}
		}
	}
}
