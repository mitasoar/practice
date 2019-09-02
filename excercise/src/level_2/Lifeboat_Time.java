package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
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
			boolean boat = false;
			for (int j = pList.size() - 1; j > 0; j--) {
				if (pList.get(0) + pList.get(j) <= limit) {
					answer++;
					pList.remove(j);
					pList.remove(0);
					boat = true;
					break;
				}
			}
			if (!boat) {
				return answer + pList.size();
			}
		}
		return answer;
	}
}
