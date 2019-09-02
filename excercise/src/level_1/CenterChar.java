package level_1;

public class CenterChar {

	public static void main(String[] args) {
		String input = "qwernq";

		String center = getCenterStr(input);
		System.out.println(center);

	}

	// 가운데 글자(캐릭터)를 리턴하는 메소드
	// 홀수개의 입력스트링 -> 가운데 캐릭터
	// 짝수개의 입력스트링 --> 가운데 2 캐릭터들
	// 입력: String
	// 리턴: String
	// 로직 :
	// 1. 입력스트링 짝수개인지 홀수개인지?
	// 2. 짝수면?
	//

	// 내꺼
	public static String getCenterStr(String str) {
		String centerStr;
		if (str.length() % 2 == 0) { // 짝수일때
			char center1 = str.charAt(str.length() / 2 - 1);
			char center2 = str.charAt(str.length() / 2);
			centerStr = String.valueOf(center1) + String.valueOf(center2);
			return centerStr;
		} else { // 홀수일때 (str.length() % 2 == 1)
			char center = str.charAt(str.length() / 2);
			centerStr = String.valueOf(center);
			return centerStr;
		}
	}


		// 선생님꺼
//	public static String getCenterStr(String str) {
//		if (str.length() % 2 == 0) { // 짝수
//			int index = str.length() / 2 - 1;
//			return str.substring(index, index + 2);			
//		} else { // 홀수
//			int index = str.length() / 2;
//			return str.substring(index, index + 1);
//		}
//	}
}
