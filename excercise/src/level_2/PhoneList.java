package level_2;

public class PhoneList {
	public boolean solution(String[] phone_book) {
		boolean answer = true;
		
		for (int i = 0; i < phone_book.length; i++) {
			for (int j = 0; j < phone_book.length; j++) {
				if (phone_book[i].length() > phone_book[j].length()) {
					continue;
				} else {
					if (i != j) {
						if (phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])) {
							return false;
						}
					}
				}
			}
		}
		
		return answer;
	}
}
