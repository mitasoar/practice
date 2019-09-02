package level_1;

import java.util.Arrays;

public class RemoveSmallNum {

	public static void main(String[] args) {

		int[] a = { 3};

		System.out.println(Arrays.toString(solution(a)));

	}

	public static int[] solution(int[] arr) {
		int[] answer = {};

		int[] brr = Arrays.copyOfRange(arr, 0, arr.length);

		if (arr.length < 2) {
			return new int[] { -1 };
		} else {
			Arrays.sort(brr);
			int answerNum = 0;
			for(int i = 0; i < brr.length; i++) {
				if (brr[0] != brr[i])
					answerNum++;
			}
			answer = new int[answerNum];
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != brr[0]) {
					answer[count] = arr[i];
					count++;
				}
			}
		}
		return answer;
	}
}
