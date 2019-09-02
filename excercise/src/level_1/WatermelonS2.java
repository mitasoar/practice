package level_1;

public class WatermelonS2 {

	public static void main(String[] args) {

		System.out.println(getMySubak(15));

	}

	public static String nStr(int n) {

		String str = "수"; // n이 1일때 "수"가 나오게끔 하기위해 설정
		String water = "수"; // n이 홀수일때 더하려고 설정
		String melon = "박"; // n이 짝수일때 더하려고 설정

		if (n == 0) {
			str = null;
		}

		for (int i = 0; i < n - 1; i++) { // 글자수(n-1)만큼 반복
			if (i % 2 == 1) { // 홀수일때
				str += water;
			} else { // 짝수일때
				str += melon;
			}

		}

		return str;

	}

	// 선생님꺼

	public static String getMySubak(int n) {
		if (n <= 0) {
			return null;
		}

		String subak = "수박";
		String result = "";
		int index = 0;
		while (n > 0) {
			result += subak.charAt(index); // result = result + subak.charAt(index)
			index++;
			if (index > 1) {
				index = 0;
			}
			n--;
		}
		return result;
	}

	// 선생님꺼2

	public static String getMySubak2(int n) {
		if (n <= 0) {
			return null;
		} else if (n == 1) {
			return "수";
		}

		String subak = "수박";
		for (int i = 0; i < n / 2 - 1; i++) {
			subak += "수박";
		}

		if (n % 2 == 0) {
			return subak;
		} else {
			return subak + "수";
		}
	}
}
