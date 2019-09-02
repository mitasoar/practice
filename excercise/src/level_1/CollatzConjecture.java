package level_1;

public class CollatzConjecture {

	public static void main(String[] args) {

	}

	public int solution(int num) {
		int answer = 0;

		long nums = (long) num;

		while (true) {
			if (nums == 1) {
				break;
			}
			
			if (nums % 2 == 0) {
				nums = nums / 2;
				answer++;
			} else {
				nums = nums * 3 + 1;
				answer++;
			}
			
			if (answer > 500) {
				return -1;
			}
		}

		return answer;
	}

}
