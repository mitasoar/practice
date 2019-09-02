package level_1;

public class FindDay {

	public static void main(String[] args) {
		int a = 1;
		int b = 17;
		System.out.println(solution(a, b));

	}

	public static String solution(int a, int b) {
		String answer = "";
		
			if (a == 2 || a == 8) {
				b += 3;
			} else if (a == 3 || a == 11) {
				b += 4;
			} else if (a == 6) {
				b += 5;
			} else if (a == 9 || a == 12) {
				b += 6;
			} else if (a == 10) {
				b += 1;
			} else if (a == 5) {
				b += 2;
			}
			

		if (b % 7 == 0) {
			answer = "THU";
		} else if (b % 7 == 1) {
			answer = "FRI";
		} else if (b % 7 == 2) {
			answer = "SAT";
		} else if (b % 7 == 3) {
			answer = "SUN";
		} else if (b % 7 == 4) {
			answer = "MON";
		} else if (b % 7 == 5) {
			answer = "TUE";
		} else if (b % 7 == 6) {
			answer = "WED";
		}

		return answer;

	}

}
