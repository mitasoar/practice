package level_2;

import java.util.*;

public class DoubleDelete {
	
	public static int solution(String s) {
		if (s.length() % 2 == 1) {
        	return 0;
        }
        
		Stack<Character> st = new Stack<>();
		
		char[] chs = s.toCharArray();
		
		for (char c : chs) {
			if (st.empty()) st.push(c);
			else {
				if (st.peek() == c) st.pop();
				else st.push(c);
			}
		}
		
		if (st.size() == 0) return 1;
		else return 0;
    }
}
