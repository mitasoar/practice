package level_2;

public class JadenCase {
	
	public String solution(String s) {
		String answer = "";
		
		s = s.toLowerCase();
		
		char[] chrs = s.toCharArray();
		
		char fir = s.charAt(0);
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				try {
					fir = chrs[i+1];
					continue;
				} catch (Exception e) {
					break;
				}
			}
			if (fir >= 'a' && fir <= 'z') {
				chrs[i] = (char)(chrs[i] - 32);
			}
			fir = '0';
		}
		
		answer = String.valueOf(chrs);
		
		return answer;
	}

}
