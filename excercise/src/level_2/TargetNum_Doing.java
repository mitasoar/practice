package level_2;

public class TargetNum_Doing {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {4, 2, 6, 1, 5}, 8));
	}
	
	public static int solution(int[] numbers, int target) {
		int answer = 0;
		
		int t = 0;
		for (int i = 0; i < numbers.length; i++) {
			 t += numbers[i];
		}
		System.out.println(t);
		if (t == target) answer++;
		
		t = 0;
		for (int i = 0; i < numbers.length; i++) {
			 t -= numbers[i];
		}
		System.out.println(t);
		if (t == target) answer++;
		
		for (int l = 0; l < numbers.length - 1; l++) {
			for (int i = 0; i < numbers.length; i++) {
				t = 0;
				for (int j = 0; j < numbers.length; j++) {
					int k = j - i;
					if (k < 0) k += numbers.length;
					if (j <= l) t -= numbers[k];
					else t += numbers[k];
				}
				System.out.println(i+1 + "번째 " + t);
				if (t == target) answer++;
			}
		}
        return answer;
	}

}
