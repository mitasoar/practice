package level_1;

import java.util.Arrays;

public class DivisorArray {

	public static void main(String[] args) {

		int[] arr = { (int) (Math.random() * 50), (int) (Math.random() * 50), (int) (Math.random() * 50),
				(int) (Math.random() * 50), (int) (Math.random() * 50) };

		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.toString(solution(arr, 3)));

	}

	public static int[] solution(int[] arr, int divisor) {

		int a = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				if (arr[i] % divisor == 0) {
					a++;
				}
			}
		}

		int[] answer;

		if (a == 0) {
			answer = new int[1];
			answer[0] = -1;
		} else {
			answer = new int[a];
			int b = 0;
			for (int i = 0; i < arr.length; i++) {
				Arrays.sort(arr);
				if (arr[i] != 0) {
					if (arr[i] % divisor == 0) {
						answer[b] = arr[i];
						b++;
					}
				}
			}
		}
		return answer;
	}
}
