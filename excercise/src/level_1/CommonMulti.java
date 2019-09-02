package level_1;

import java.util.Arrays;

public class CommonMulti {

	public static void main(String[] args) {
		
		int[] a = solution(6, 34);
		
		System.out.println(Arrays.toString(a));

	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
//		
//		int[] divisorN = divisor(n);
//		
//		int[] divisorM = divisor(m);
//		
//		for (int i = divisorN.length - 1; i > -1 ; i--) {
//			if (answer[0] == 0) {
//				for(int j = divisorM.length - 1; j > -1 ; j--) {
//					if (divisorN[i] == divisorM[j]) {
//						answer[0] = divisorN[i];
//						break;
//					}
//				}
//			}
//		}
		
		for (int i = n ; i < n*m + 1 ; i += n) {
			if (answer[1] == 0) {
				for (int j = m ; j < n*m + 1 ; j += m) {
					if (i == j) {
						answer[1] = i;
						break;
					}
				}
			}
		}
		
		answer[0] = n*m/answer[1];
		
		return answer;
	}

//	public static int[] divisor(int a) {
//		int num = 0;
//		int dNum = 0;
//		for (int i = 1; i < a + 1; i++){
//			if (a % i == 0) {
//				num++;
//			}
//		}
//		int[] divisor = new int[num];
//		
//		for (int i = 1; i < a + 1; i++){
//			if (a % i == 0) {
//				divisor[dNum] = i;
//				dNum++;
//			}
//		}
//		
//		return divisor;
//		
//	}
	
}
