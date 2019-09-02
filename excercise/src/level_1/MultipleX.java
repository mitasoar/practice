package level_1;

public class MultipleX {

	public static void main(String[] args) {

	}

	public long[] solution(int x, int n) {
		
		long[] answer = new long[n];
		
		int num = 1;
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = (long)x * num;
			num++;
		}
		
		return answer;
	}

}
