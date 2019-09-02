package level_1;

public class DescendingOrder {

	public static void main(String[] args) {

	}

	public static String solution(String s) {
		String answer = "";
		
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if (ch[i] > ch[j]) {
					char cha = ch[j];
					ch[j] = ch[i];
					ch[i] = cha;
				}
			}
		}
		
		answer = String.copyValueOf(ch);
		
		return answer;
	}

}
