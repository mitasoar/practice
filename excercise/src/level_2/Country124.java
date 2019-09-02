package level_2;

public class Country124 {

	public static void main(String[] args) {

		for (int i = 41; i < 100; i++) {
			System.out.println(solution(i));
		}

	}

	public static String solution(int n) {

		String answer = "";

		int j = 0;
		int k = 1;
		while (true) {
			if (n < k)
				break;
			k += Math.pow(3, ++j);
		}

		while (true) {
			int c = 0;
			while (true) {
				n -= Math.pow(3, j - 1);
				c++;
				if (j == 1) {
					if (n < 1)
						break;
				} else {
					int s = 0;
					int e = j;
					for (; e > 1; e--) {
						s += Math.pow(3, e - 1);
					}
					if (n <= s)
						break;
				}
			}
			switch (c) {
			case 3:
				answer += 4;
				break;
			case 2:
				answer += 2;
				break;
			case 1:
				answer += 1;
				break;
			}
			j--;
			if (j < 1)
				break;
		}
		return answer;
	}

}
