package level_2;

import java.util.ArrayList;
import java.util.List;

public class NumBaseball_Doing {

	public static void main(String[] mita) {
		System.out.println(solution(new int[][] { { 123, 1, 1 }, { 356, 1, 0 }, { 327, 2, 0 }, { 489, 0, 1 } }));
	}

	public static int solution(int[][] baseball) {
		int answer = 1;

		List<int[]> list = new ArrayList<>();

		for (int i = 0; i < baseball.length; i++) {
			if (baseball[i][1] > 0) {
				list.add(baseball[i]);
			}
		}

		char[] copy = new char[String.valueOf(baseball[0][0]).length()];

		for (int i = 0; i < list.size(); i++) {
			String str = String.valueOf(list.get(i)[0]);
			for (int j = 0; j < list.size(); j++) {
				if (i != j) {
					String str2 = String.valueOf(list.get(j)[0]);
					for (int k = 0; k < str.length(); k++) {
						if (str.charAt(k) == str2.charAt(k)) {
							copy[k] = str.charAt(k);
						}
					}
				}
			}
		}
		
		boolean b = true;
		int a = 0;
		for (int i = 0; i < copy.length; i++) {
			if (copy[i] == '\u0000') {
				b = false;
				a++;
			}
		}
		if (b == true) {
			return answer;
		}
		
		for (int i = 0; i < baseball.length; i++) { // 스트라이크
			char[] chrs = String.valueOf(baseball[i][0]).toCharArray();
			int num = baseball[i][1];
			if (num > 0) {
				for (int j = 0; j < chrs.length; j++) {
					if (chrs[j] == '0') {
						return 0;
					} else if (chrs[j] == copy[j]) {
						num--;
					}
					if (num == 0) break;
				}
			}
			if (num != 0) {
				return answer;
			}
		}
		
		for (int i = 0; i < baseball.length; i++) { // 볼
			char[] chrs = String.valueOf(baseball[i][0]).toCharArray();
			int num = baseball[i][1] + baseball[i][2];
			if (num > 0) {
				for (int j = 0; j < chrs.length; j++) {
					if (chrs[j] == copy[0] || chrs[j] == copy[1] || chrs[j] == copy[2]) {
						num--;
					}
					if (num == 0) break;
				}
			}
			if (num != 0) {
			}
		}

		return answer;
	}
}
