package level_1;

public class PlusIndexNum {

	public static void main(String[] args) {

		int a = 5342;
		
		System.out.println(String.valueOf(a));
		
		System.out.println(solution(a));
		
	}

	public static int solution(int n) {
		int answer = 0;
		
		String s = String.valueOf(n);
		
		for (int i = 0; i < s.length(); i++) {
			answer += s.charAt(i) - 48;
		}

		return answer;
	}

}
