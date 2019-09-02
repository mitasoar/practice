package level_1;

import java.util.Arrays;

public class HateSameNum {

	public static void main(String[] args) {

		int[] arr = new int[10];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10);
		}

		System.out.println(Arrays.toString(arr));

		System.out.println(Arrays.toString(sortNum(arr)));

	}

	public static int[] sortNum(int[] num) {
		int sortNum = num.length;

		for (int i = 0; i < num.length - 1; i++) {
			if (num[i] < 10) {
				for (int j = i + 1; j < num.length; j++) {
					if (num[i] == num[j]) {
						num[j] = 10;
						sortNum--;
					} else {
						break;
					}
				}
			}
		}

		int[] sort = new int[sortNum];

		int j = 0;

		for (int i = 0; i < num.length; i++) {
			if (num[i] < 10) {
				sort[j] = num[i];
				j++;
			}
		}
		return sort;

	}

}
