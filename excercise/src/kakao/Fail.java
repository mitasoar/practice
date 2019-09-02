package kakao;

import java.util.Arrays;

public class Fail {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
	}
	
	public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] per = new double[N];
        
        for (int i = 1; i <= N; i++) {
        	int clear = 0;
        	int pass = 0;
        	for (int j = 0; j < stages.length; j++) {
        		if (stages[j] > i) clear++;
        		if (stages[j] >= i) pass++;
        	}
        	int doing = pass - clear;
        	if (pass == 0 || doing == 0) {
        		per[i - 1] = 0;
        	} else {
        		per[i - 1] = doing / (double)pass;
        	}
        }
        
        for (int i = 0; i < per.length; i++) {
        	double d = -1;
        	int num = 0;
        	for (int j = 0; j < per.length; j++) {
        		if (d < per[j]) {
        			d = per[j];
        			num = j;
        		}
        	}
        	answer[i] = num + 1;
        	per[num] = -1;
        }
        
        return answer;
    }

}
