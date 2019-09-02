package level_1;

public class StringPY {

	public static void main(String[] args) {
	
		

	}
	
	public static boolean solution(String s) {
        boolean answer = true;
        
        int p = 0;
        int y = 0;

        for (int i = 0; i < s.length(); i++) {
        	if (s.charAt(i) == 'p' || s.charAt(i) == 'P') {
        		p++;
        	} else if (s.charAt(i) == 'y' || s.charAt(i) == 'Y') {
        		y++;
        	}
        }
        
        if (p != y) {
        	return false;
        }

        return answer;
    }

}
