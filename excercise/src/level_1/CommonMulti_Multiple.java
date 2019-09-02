package level_1;

public class CommonMulti_Multiple {

	public static void main(String[] args) {
		System.out.println(solution(7, 3));
	}

	public static int[] solution(int n, int m) {
		int[] answer = new int[2];
		
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
}
