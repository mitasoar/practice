package level_2;

import java.util.Arrays;

public class MakeLargeNum {

	public static void main(String[] mita) {
//		System.out.println(solution("123456789", 4));
//		System.out.println("다음");
//		System.out.println(solution("84965", 2));
//		System.out.println("다음");
//		System.out.println(solution("8496", 2));
//		System.out.println("다음");
//		System.out.println(solution("561828917", 4));
//		System.out.println("다음");
//		System.out.println(solution("291874621", 4));
//		System.out.println("다음");
//		System.out.println(solution("987654321", 4));
//		System.out.println("다음");
//		System.out.println(solution("987654321", 2));
//		System.out.println(solution("1231234", 3));
//		System.out.println("다음");
//		System.out.println(solution("4177252841", 4));
//		System.out.println("다음");
		System.out.println(solution("10000", 2));
	}

	public static String solution(String number, int k) {
		String answer = "";
		int j = number.length() - k;
		int l = number.length() - k;
		while (true) {
			int a = 9;
			while (true) {
				String aStr = String.valueOf(a);
				if (number.indexOf(aStr) > -1) {
					if (number.length() - number.indexOf(aStr) > l) {
						answer += a;
						number = number.substring(number.indexOf(aStr) + 1);
						l--;
						break;
					} else if (number.length() - number.indexOf(aStr) == l) {
						return answer += number.substring(number.indexOf(aStr));
					} else if (number.length() - number.indexOf(aStr) < l) {
						a--;
						continue;
					}
				} else {
					a--;
					continue;
				}
			}
			if (l == 0) {
				return answer;
			}
			if (answer.length() == j) {
				return answer;
			}
		}
	}
}
