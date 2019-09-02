package level_2;

import java.util.Arrays;

public class MakeMinimumValue {

	public int solution(int[] A, int[] B) {
		int answer = 0;
		int l = B.length - 1;

		Arrays.sort(A);
		Arrays.sort(B);

		for (int i = 0; i < A.length; i++) {
			answer += A[i] * B[l];
			l--;
		}

		return answer;
	}

}
