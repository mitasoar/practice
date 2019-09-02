package level_2;

import java.util.Arrays;

public class RamenFactory {
	
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 4, 15, 20}, new int[] {20, 9, 4, 5}, 30));
		System.out.println(solution(4, new int[] {1, 2, 3, 4}, new int[] {10, 40, 30, 20}, 100));
	}
	
	public static int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        
        if (stock >= k) return answer;
        
        while (true) {
        	int f = 0;
        	int index = 0;
            for (int i = 0; i < dates.length; i++) {
            	if (dates[i] <= stock) {
            		if (supplies[i] > f) {
            			f = supplies[i];
            			index = i;
            		}
            	}
            }
           
            stock += f;
            answer++;
            
            if (stock >= k) return answer;
            
            int[] a = Arrays.copyOfRange(dates, 0, index);
            int[] b = Arrays.copyOfRange(dates, index + 1, dates.length);
            dates = new int[dates.length - 1];
            System.arraycopy(a, 0, dates, 0, a.length);
            System.arraycopy(b, 0, dates, a.length, b.length);
            
            a = Arrays.copyOfRange(supplies, 0, index);
            b = Arrays.copyOfRange(supplies, index + 1, supplies.length);
            supplies = new int[supplies.length - 1];
            System.arraycopy(a, 0, supplies, 0, a.length);
            System.arraycopy(b, 0, supplies, a.length, b.length);
        }
    }
}
