package level_2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Camouflage {

	public static int solution(String[][] clothes) {
		int answer = 1;

		List<String[]> list = new ArrayList<>();
		for (String[] strs : clothes) {
			list.add(strs);
		}

		Set<String> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i)[1]);
		}

		List<Integer> nums = new ArrayList<>();

		if (set.size() == 1) {
			return clothes.length;
		} else {
			Iterator<String> itor = set.iterator();
			while (itor.hasNext()) {
				String str = itor.next();
				int num = 0;
				for (int i = 0; i < list.size(); i++) {
					if (list.get(i)[1].equals(str)) {
						num++;
					}
				}
				nums.add(num);
			}
		}

		for (int i = 0; i < nums.size(); i++) {
			answer *= nums.get(i) + 1;
		}

		return answer - 1;
	}
}
