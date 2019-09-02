package level_2;

import java.util.ArrayList;
import java.util.List;

public class IronBar {

	public int solution(String arrangement) {
		int answer = 0;

		int num = 0;
		List<Integer> start = new ArrayList<>();
		List<Integer> end = new ArrayList<>();

		for (int i = 0; i < arrangement.length() - 1; i++) {
			if (arrangement.charAt(i) == '(' && arrangement.charAt(i + 1) == ')') {
				for (int j = num; j < i; j++) {
					if (arrangement.charAt(j) == '(') {
						start.add(j);
					}
				}
				num = i + 2;
				for (int j = i + 2; j < arrangement.length(); j++) {
					if (arrangement.charAt(j) == ')') {
						end.add(j);
					} else
						break;
				}
			}
		}
		int[][] bar = new int[start.size()][2];
		int a = 0;

		for (int i = start.size() - 1; i > -1; i--) {
			for (int j = 0; j < end.size(); j++) {
				if (start.get(i) < end.get(j)) {
					bar[a][0] = start.get(i);
					bar[a][1] = end.get(j);
					start.remove(i);
					end.remove(j);
					a++;
					break;
				}
			}
		}
		answer = bar.length;

		for (int i = 0; i < bar.length; i++) {
			for (int j = bar[i][0]; j < bar[i][1]; j++) {
				if (arrangement.charAt(j) == '(' && arrangement.charAt(j + 1) == ')') {
					answer++;
				}
			}
		}
		return answer;
	}

}
