package level_2;

public class EnglishEndword {
	public int[] solution(int n, String[] words) {
        int[] answer = {0, 0};
        
        for (int i = 1; i < words.length; i++) {
        	if (words[i].charAt(0) != words[i - 1].charAt(words[i - 1].length() - 1)) {
        		return new int[]{(i + 1) % n == 0 ? n : (i + 1) % n, (i + 1) % n == 0 ? (i + 1) / n : ((i + 1) / n) + 1};
        	}
        	for (int j = 0; j < i; j++) {
        		if (words[i].equals(words[j])) {
        			return new int[]{(i + 1) % n == 0 ? n : (i + 1) % n, (i + 1) % n == 0 ? (i + 1) / n : ((i + 1) / n) + 1};
        		}
        	}
        }
        
        return answer;
    }
}
