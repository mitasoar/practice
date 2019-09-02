package level_2;

public class Tournament {

	public int solution(int n, int a, int b){
        int answer = 1;
        
        while (true) {
        	if (a % 2 == 1) {
        		a += 1;
        	}
        	if (b % 2 == 1) {
        		b += 1;
        	}
        	
        	if (a == b) {
        		return answer;
        	} else {
        		answer++;
        		a /= 2;
        		b /= 2;
        	}
        }

    }
	
}
