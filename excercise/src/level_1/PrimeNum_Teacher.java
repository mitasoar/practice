package level_1;

public class PrimeNum_Teacher {

	public static void main(String[] args) {
		int k = 6165;
		int result = findnum(k);

		System.out.println(result);
	}

	public static int findnum(int k) {
		int count = 0;
		// 2 부터 k까지 소수의 수를
		for (int i = 2; i <= k; i++) {
			// i가 소수인지?
			if (isPrime(i) == true) {
				count++;
			}
		}
		return count;
	}

	public static boolean isPrime(int val) {
		int count = 0;
		for (int i = 1; i <= val; i++) {
			if (val % i == 0) {
				count++;
			}
		}

		if (count == 2) {
			return true;
		} else {
			return false;
		}
	}
}
