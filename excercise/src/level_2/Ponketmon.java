package level_2;

public class Ponketmon {
	
	public int solution(int[] nums) {
        int answer = 0;
        
        int[] pok = new int[nums.length / 2];
        int in = 0;
        
        for (int i = 0; i < nums.length; i++) {
        	if (in < pok.length) {
        		if (in == 0) {
            		pok[in++] = nums[i];
            		answer++;
            	} else {
            		boolean t = true;
            		for (int j = 0; j < in; j++) {
            			if (pok[j] == nums[i]) {
            				t = false;
            				break;
            			}
            		}
            		if (t) {
            			pok[in++] = nums[i];
                		answer++;
            		}
            	}	
            } else {
            	return answer;
            }
        }
        
        return answer;
    }

}
