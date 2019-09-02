package level_1;

public class SquareRoot_Why {

	public static void main(String[] args) {

		long a = 144l;
		
		System.out.println(solution(a));
		
	}

	public static long solution(long n) {
		
		for (long i = 1; i * i <= n; i++) {
			if (i * i == n) {
				return (long)(i + 1) * (long)(i + 1);
			}
		}
		
		return -1;
		
//		int num = 0;
//		int dNum = 0;
//		for (long i = 1; i < n + 1; i++) {
//			if (n % i == 0) {
//				num++;
//			}
//		}
//		
//		if (num % 2 == 0) {
//			return -1;
//		}
//
//		long[] div = new long[num];
//
//		for (int i = 1; i < n + 1; i++) {
//			if (n % i == 0) {
//				div[dNum] = i;
//				dNum++;
//			}
//		}
//		return (div[div.length / 2] + 1) * (div[div.length / 2] + 1);
	}

}
