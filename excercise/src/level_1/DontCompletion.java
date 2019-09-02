package level_1;

import java.util.Arrays;

public class DontCompletion {

	public static void main(String[] args) {

		String[] abc = { "leo", "kiki", "eden" };

		String[] ab = { "kiki", "eden" };

		System.out.println(solution(abc, ab));

	}

	public static String solution(String[] participant, String[] completion) {

		// 시간초과 ㅡㅡ
//		for (int i = 0; i < completion.length; i++) {
//			for (int j = 0; j < participant.length; j++) {
//				if (completion[i].equals(participant[j])) {
//					participant[j] = null;
//					break;
//				}
//			}
//		}
//		
//		int a = 0;
//		
//		for (int i = 0; i < participant.length; i++) {
//			if (participant[i] != null) {
//				a = i;
//			}
//		}

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < participant.length - 1; i++) {
			if (!participant[i].equals(completion[i])) {
				return participant[i];
			}
		} 
		return participant[participant.length - 1];
	} 
}
