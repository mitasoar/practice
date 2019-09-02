package level_2;

import java.util.Arrays;

public class Carpet {
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(24, 24)));
	}

//	public int[] solution(int brown, int red) {
//		int[] answer = {};
//
//		int size = brown + red;
//
//		int num = (int) Math.sqrt(size);
//
//		while (true) {
//			if (size % num == 0) {
//				if (num >= size / num)
//					return new int[] { num, size / num };
//				else
//					return new int[] { size / num, num };
//			}
//			num++;
//		}
//	}
	
	public static int[] solution(int brown, int red) {
		int[] answer = {};

		if (brown >= Math.pow(red, 2)) {
			if (brown == 6 + red * 2) return new int[] {red + 2, 3};
		} else {
			for (int i = 2;; i++) {
				if (red % i == 0) {
					int rW = red / i;
					if (brown == rW * 2 + i * 2 + 4) return new int[] {rW + 2, i + 2};
				}
			}
		}
		
		return answer;
	}
}
