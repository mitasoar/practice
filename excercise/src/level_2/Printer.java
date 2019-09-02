package level_2;

import java.util.ArrayList;
import java.util.List;

public class Printer {
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < priorities.length; i++) {
			list.add(priorities[i]);
		}

		for (int i = 0; i < list.size(); i++) {
			if (i > location) {
				break;
			}
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i) < list.get(j)) {
					list.add(list.get(i));
					list.remove(i);
					if (i == location) {
						location = list.size() - 1;
						i = -1;
						break;
					}
					location--;
					i = -1;
					break;
				}
			}
		}
		answer = location + 1;
		return answer;
	}

}
