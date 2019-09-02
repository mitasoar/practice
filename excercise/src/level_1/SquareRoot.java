package level_1;

public class SquareRoot {

	public static void main(String[] args) {

		
	}

	public static long solution(long n) {
		
		for (long i = 1; i * i <= n; i++) {
			if (i * i == n) {
				return (long)(i + 1) * (long)(i + 1);
			}
		}
		
		return -1;
	
	}

}
