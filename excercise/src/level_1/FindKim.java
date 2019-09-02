package level_1;

import java.util.Arrays;

public class FindKim {

	public static void main(String[] args) {
		
		String[] seoul = {"Hello", "Park", "Choi", "New", "Woo", "Kim", "Seo"};

		System.out.println(findKim(seoul));

	}

	// 킴서방 찾는 메소드
	// 입력: String[]
	// 출력: String
	
	public static String findKim(String[] seoul) {
		
		int findNum = 0;
		
		for (int i = 0; i < seoul.length; i++) {
			if (seoul[i].equalsIgnoreCase("kim")) { // .equalsIgnoreCase() 대소문자 구별없이 비교
				findNum = i;
			}
		}
		
		String find = "김서방은 " + findNum + "에 있다";
		
		return find;
	}
}
