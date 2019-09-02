package level_1;

import java.util.Arrays;

public class FindKthNum {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] com = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 }};

		int[] result = findKthNumbers(arr, com);
		System.out.println(Arrays.toString(result));
	}

	public static int[] findKthNumbers(int[] array, int[][] ijk) {
		int[] find = new int[ijk.length];
		int i = 0;
		while (i < ijk.length) {
			int startCut = ijk[i][0];
			int endCut = ijk[i][1];
			int cutNum = ijk[i][2];
			
			int[] arrayCut = Arrays.copyOfRange(array, startCut - 1, endCut);
			Arrays.sort(arrayCut);
			
			find[i] = arrayCut[cutNum - 1];
			i++;
		}

		return find;
	}

}
