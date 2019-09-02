package level_1;

public class CommonMulti_Divisor {

	public static void main(String[] args) {

	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];

		int[] divisorN = divisor(n);

		int[] divisorM = divisor(m);

		for (int i = divisorN.length - 1; i > -1; i--) {
			if (answer[0] == 0) {
				for (int j = divisorM.length - 1; j > -1; j--) {
					if (divisorN[i] == divisorM[j]) {
						answer[0] = divisorN[i];
						break;
					}
				}
			}
		}

		answer[1] = n * m / answer[0];

		return answer;
	}

	public static int[] divisor(int a) {
		int num = 0;
		int dNum = 0;
		for (int i = 1; i < a + 1; i++) {
			if (a % i == 0) {
				num++;
			}
		}
		int[] divisor = new int[num];

		for (int i = 1; i < a + 1; i++) {
			if (a % i == 0) {
				divisor[dNum] = i;
				dNum++;
			}
		}

		return divisor;

	}

}
