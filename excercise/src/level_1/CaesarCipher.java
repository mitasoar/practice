package level_1;

public class CaesarCipher {

	public static void main(String[] args) {
		
		System.out.println(solution("a B z" , 4));

	}

	public static String solution(String s, int n) {
		String answer = "";
		
		char[] ch = s.toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= 'a' && ch[i] <= 'z') {
				ch[i] = (char)((int)ch[i] + n);
				if (ch[i] > 'z'){
					ch[i] = (char)((int)ch[i] - 26);
				} 
			} else if (ch[i] >= 'A' && ch[i] <= 'Z') {
				ch[i] = (char)((int)ch[i] + n);
				if (ch[i] > 'Z') {
					ch[i] = (char)((int)ch[i] - 26);
				}
			}
		}
		
		answer = new String(ch);
		
		return answer;
	}

}
