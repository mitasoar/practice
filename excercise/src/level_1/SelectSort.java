package level_1;

import java.util.Arrays;

public class SelectSort {

	public static void main(String[] args) {
		

	}
	
	public static int[] selcetSort(int[] arr) {
		int[] sortArr = Arrays.copyOfRange(arr, 0, arr.length);
		
		for (int i = 0; i < sortArr.length - 1; i++) {
			int b = 0;
			int c = sortArr[i];
			for (int j = i + 1; j < sortArr.length; j++) {
				if (sortArr[j] < c) {
					b = j;
					c = sortArr[j];
				}
			}
			if (b != 0) {
				int d = sortArr[i];
				sortArr[i] = sortArr[b];
				sortArr[b] = d;
			}
		}
		
		return sortArr;
		
	}

}
