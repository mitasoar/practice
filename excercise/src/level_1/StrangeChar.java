package level_1;

public class StrangeChar {

	public static void main(String[] args) {

		String s = "Hello World Cup";

		System.out.println(solution(s));

	}

	public static String solution(String s) {
		String answer = "";

		char[] ch = s.toCharArray();

		int j = 0;

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z' || ch[i] >= 'A' && ch[i] <= 'Z') {
				if (j % 2 == 1) {
					if (ch[i] >= 'A' && ch[i] <= 'Z') {
						ch[i] = (char) ((int) ch[i] + 32);
					}
					j++;
					continue;
				} else {
					if (ch[i] >= 'a' && ch[i] <= 'z') {
						ch[i] = (char) ((int) ch[i] - 32);
					}
					j++;
					continue;
				}
			}
			j = 0;
		}
		
		answer = new String(ch);

		return answer;
	}

}
