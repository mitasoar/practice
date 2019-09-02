package level_1;

import java.util.Arrays;

public class MySort {

	public static void main(String[] args) {

		String[] abc = { "ctx", "abcd", "abce", "aacf" };

		System.out.println(Arrays.toString(solution(abc, 2)));

	}

	public static String[] solution(String[] strings, int n) {
		String[] answer = new String[strings.length];

		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].charAt(n) > strings[j].charAt(n)) {
					String str = strings[i];
					strings[i] = strings[j];
					strings[j] = str;
				}
			}
		}
		
		for (int i = 0; i < strings.length - 1; i++) {
			for (int j = i + 1; j < strings.length; j++) {
				if (strings[i].charAt(n) == strings[j].charAt(n)) {
					Arrays.sort(strings, i, j + 1);
				}
			}
		}

		answer = strings;

		return answer;
	}

}
