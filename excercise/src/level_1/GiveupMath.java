package level_1;

import java.util.Arrays;

public class GiveupMath {

	public static void main(String[] args) {

		int[] a = { 1, 3, 2, 4, 2 };
		int[] b = solution(a);

		System.out.println(Arrays.toString(b));
	}

	public static int[] solution(int[] answers) {

		int[] aa = new int[answers.length];
		int[] bb = new int[answers.length];
		int[] cc = new int[answers.length];

		int a = 0;
		int b = 0;
		int c = 0;

		int num = 1;

		for (int i = 0; i < answers.length; i++) {
			aa[i] = num;
			num++;
			if (num == 6) {
				num = 1;
			}
		}

		for (int i = 0; i < answers.length; i++) {
			if (i % 8 == 0) {
				bb[i] = 2;
			} else if (i % 8 == 1) {
				bb[i] = 1;
			} else if (i % 8 == 2) {
				bb[i] = 2;
			} else if (i % 8 == 3) {
				bb[i] = 3;
			} else if (i % 8 == 4) {
				bb[i] = 2;
			} else if (i % 8 == 5) {
				bb[i] = 4;
			} else if (i % 8 == 6) {
				bb[i] = 2;
			} else if (i % 8 == 7) {
				bb[i] = 5;
			}
		}

		for (int i = 0; i < answers.length; i++) {
			if (i % 10 == 0 || i % 10 == 1) {
				cc[i] = 3;
			} else if (i % 10 == 2 || i % 10 == 3) {
				cc[i] = 1;
			} else if (i % 10 == 4 || i % 10 == 5) {
				cc[i] = 2;
			} else if (i % 10 == 6 || i % 10 == 7) {
				cc[i] = 4;
			} else if (i % 10 == 8 || i % 10 == 9) {
				cc[i] = 5;
			}
		}

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == aa[i]) {
				a++;
			}
			if (answers[i] == bb[i]) {
				b++;
			}
			if (answers[i] == cc[i]) {
				c++;
			}
		}

		int[] answer = {};

		if (a == answer.length) {
			int[] first = { 1 };
			answer = first;
			System.out.println("수포자 1은 모든 문제를 맞췄습니다.");
		} else if (b == answer.length) {
			int[] first = { 2 };
			answer = first;
			System.out.println("수포자 2은 모든 문제를 맞췄습니다.");
		} else if (c == answer.length) {
			int[] first = { 3 };
			answer = first;
			System.out.println("수포자 3은 모든 문제를 맞췄습니다.");
		} else if (a > b && a > c) {
			int[] first = { 1 };
			answer = first;
			System.out.println("수포자 1은 " + a + "문제를 맞췄습니다.");
		} else if (a == c && a > b) {
			int[] first = { 1, 3 };
			answer = first;
			System.out.println("수포자 1,3은 " + a + "문제를 맞췄습니다.");
		} else if (a == b && a > c) {
			int[] first = { 1, 2 };
			answer = first;
			System.out.println("수포자 1,2은 " + a + "문제를 맞췄습니다.");
		} else if (b > a && b > c) {
			int[] first = { 2 };
			answer = first;
			System.out.println("수포자 2은 " + b + "문제를 맞췄습니다.");
		} else if (b == c && b > a) {
			int[] first = { 2, 3 };
			answer = first;
			System.out.println("수포자 2,3은 " + b + "문제를 맞췄습니다.");
		} else if (c > a && c > b) {
			int[] first = { 3 };
			answer = first;
			System.out.println("수포자 3은 " + c + "문제를 맞췄습니다.");
		} else if (a == b && b == c) {
			int[] first = { 1, 2, 3 };
			answer = first;
			System.out.println("모든 수포자들이" + c + "문제를 맞췄습니다.");
		}

		return answer;
	}

}
