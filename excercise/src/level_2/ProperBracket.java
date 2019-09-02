package level_2;

public class ProperBracket {

	boolean solution(String s) {
		boolean answer = true;
		
		int a = 0;
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				a++;
			} else {
				a--;
			}
			if (a < 0) return false;
		}
		if (a > 0) return false;

		return answer;
	}

}
