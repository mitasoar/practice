package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastCommonMultiple_yet {
	public static void main(String[] mita) {
		System.out.println(solution(new int[] { 5, 8, 7, 14 }));
	}

	public static int solution(int[] arr) {
		int answer = 1;

		Arrays.sort(arr);

		List<Integer> arr1 = new ArrayList<>();

		List<Integer> arr2 = new ArrayList<>();

		boolean b = false;

		for (int i = 2; i <= arr[0]; i += 2) {
			b = false;

			if (i == 2) {
				for (int j : arr) {
					if (j % i == 0) {
						b = true;
						continue;
					} else {
						b = false;
						break;
					}
				}

				if (b) {
					for (int j : arr) {
						arr1.add(j / i);
					}
					answer *= i;
					i = 1;
					continue;
				} else {
					for (int j : arr) {
						arr1.add(j);
					}
					i = 1;
					continue;
				}
			}

			for (int j = 0; j < arr1.size(); j++) {
				if (arr1.get(j) % i == 0) {
					b = true;
					continue;
				} else {
					b = false;
					break;
				}
			}

			if (b) {
				arr2 = arr1;

				arr1.clear();

				for (int j = 0; j < arr2.size(); j++) {
					arr1.add(arr2.get(j) / i);
				}
				answer *= i;
			}
		}
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		System.out.println(" and " + answer);

		if (arr1.size() > 0) {
			for (int i = 0; i < arr1.size(); i++) {
				answer *= arr1.get(i);
			}
		} else {
			for (int i : arr) {
				answer *= i;
			}
		}

		return answer;
	}
}
