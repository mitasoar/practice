package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Lifeboat {
	public int solution(int[] people, int limit) {
		int answer = 0;

		if (people.length == 1) {
			return 1;
		}

		Arrays.sort(people);

		if (people[0] + people[1] > limit) {
			return people.length;
		}

		List<Integer> pList = new ArrayList<>();

		for (int a : people) {
			pList.add(a);
		}

		while (pList.size() > 1) {
			if (pList.get(0) + pList.get(pList.size() - 1) <= limit) {
				answer++;
				pList.remove(pList.size() - 1);
				pList.remove(0);
			} else {
				answer++;
				pList.remove(pList.size() - 1);
			}
		}

		if (pList.size() == 1) {
			return answer + 1;
		} else {
			return answer;
		}
	}
}
