package level_2;

import java.util.Arrays;

public class JoyStick {

	public static void main(String[] mita) {
		System.out.println(solution("ROSEMARY"));
		System.out.println(solution("AABAAACAAAAAD"));
		System.out.println(solution("AAZAAAAAAZAAA"));
	}

	public static int solution(String name) {

		int answer = 0;

		char[] chars1 = new char[] { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N' };
		char[] chars2 = new char[] { 'A', 'Z', 'Y', 'X', 'W', 'V', 'U', 'T', 'S', 'R', 'Q', 'P', 'O', 'N' };

		for (int i = 0; i < name.length(); i++) {
			if (name.charAt(i) != 'A') {
				for (int j = 0; j < chars1.length; j++) {
					if (name.charAt(i) == chars1[j]) {
						answer += j;
						break;
					} else if ((name.charAt(i) == chars2[j])) {
						answer += j;
						break;
					}
				}
			}
		}

//		 여기까지 알파벳 바꾸는 조이스틱 수 구함

//		 이제 커서를 어떻게 옴기는지만 구하면 됨

//		 처음에 뒤로갈지 앞으로갈지 결정하고, 계속 그렇게 해야함

//		 커서 위치를 기억하고 위치기준으로 다음이동할곳을 찾아야함 히밤
		
		char[] charName = name.toCharArray();
		charName[0] = 'A';

		for (int i = 1; i < charName.length; i++) {
			if (charName[i] != 'A' && charName[i] != '\u0000') {
				answer += i;
				charName[i] = 'A';
				charName = Arrays.copyOfRange(charName, i, charName.length + i);
				i = 0;
				continue;
			} else if (charName[charName.length - i] != 'A' && charName[charName.length - i] != '\u0000') {
				answer += i;
				charName[charName.length - i] = 'A';
				char[] charName2 = Arrays.copyOfRange(charName, 0, charName.length - i);
				charName = new char[charName.length];
				int num = 0;
				for (int j = i; j < charName.length; j++) {
					charName[j] = charName2[num];
					num++;
				}
				i = 0;
				continue;
			}
		}
		
		return answer;
	}
}
