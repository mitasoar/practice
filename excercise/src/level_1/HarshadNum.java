package level_1;

public class HarshadNum {

	public static void main(String[] args) {
	
	}

	public boolean solution(int x) {
		boolean answer = false;
		
		char[] ch = String.valueOf(x).toCharArray();
		
		int num = 0;
		
		for (int i = 0; i < ch.length; i++) {
			num += ch[i] - 48;
		}
		
		if (x % num == 0) {
			return true;
		}
		
		return answer;
	}

}
