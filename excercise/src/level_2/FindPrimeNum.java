package level_2;

import java.util.*;

public class FindPrimeNum {

	public static void main(String[] mita) {
		System.out.println(solution("17"));
	}

	public static int solution(String numbers) {
		int answer = 0;

		char[] chs = numbers.toCharArray();

		Arrays.sort(chs);

		String strNum = "";

		for (int i = chs.length-1; i >= 0; i--) strNum += chs[i];
		
		int num = Integer.parseInt(strNum);

		List<String> list = new ArrayList<>();

		for (int i = 2; i <= num; i += 2) {
			if (i == 2) {
				list.add(i + "");
				i = 1;
				continue;
			}

			boolean b = true;
			for (int j = 3; j <= Math.sqrt(i); j += 2) {
				if (i % j == 0) {
					b = false;
					break;
				}
			}
			if (b) {
				list.add(i + "");
			}
		}
		
		for (int i = 0; i < list.size(); i++) {
			StringBuffer sb = new StringBuffer(numbers);
			String str = list.get(i);
			boolean add = true;
			for (int j = 0; j < str.length(); j++) {
				boolean t = true;
				for (int k = 0; k < sb.length(); k++) {
					if (str.charAt(j) == sb.charAt(k)) {
						sb.deleteCharAt(k);
						t = false;
						break;
					}
				}
				if (t) {
					add = false;
					break;
				}
			}
			if (add) answer++;
		}
		
		return answer;
	}

}
