package level_1;

public class TrainingClothes {

	public static void main(String[] args) {

		int a = 5;
		int[] b = { 2,3 };
		int[] c = { 5,3 };

		System.out.println(solution(a, b, c));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
int answer = 0;
        
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lost[i] = 0;
                    reserve[j] = 0;
                }
            }
        }
        
		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] != 0 && reserve[j] != 0) {
                    if (lost[i] == reserve[j]) {
						lost[i] = 0;
						reserve[j] = 0;
						break;
					}
					if (lost[i] + 1 == reserve[j] || lost[i] - 1 == reserve[j]) {
						lost[i] = 0;
						reserve[j] = 0;
						break;
					}
				}
			}
		}
		
		for (int i = 0; i < lost.length; i++) {
			if (lost[i] != 0) {
				answer++;
			}
		}
		
		answer = n - answer;
		
        return answer;
	}

}
