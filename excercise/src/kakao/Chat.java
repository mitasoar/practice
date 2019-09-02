package kakao;

import java.util.*;

public class Chat {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo",
				"Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan" })));
	}

	public static String[] solution(String[] record) {
		String[] answer = {};

		HashMap<String, String> change = new HashMap<>(); // 마지막 닉네임을 저장해놓을 Map

		for (int i = 0; i < record.length; i++) {
			if (!record[i].startsWith("Leave")) {
				String[] user = record[i].split(" "); // 변경하는 사용자 정보
				change.put(user[1], user[2]); // Map key에는 사용자의 ID, value에는 사용자의 변경 닉네임
			}
		}

		for (int i = 0; i < record.length; i++) {
			if (record[i].startsWith("Enter")) { // 사용자 입장 일 때
				String[] user = record[i].split(" "); // 사용자 정보
				answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
				answer[answer.length - 1] = change.get(user[1]) + "님이 들어왔습니다.";
			} else if (record[i].startsWith("Leave")) { // 사용자 퇴장 일 때
				String[] user = record[i].split(" "); // 사용자 정보
				answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
				answer[answer.length - 1] = change.get(user[1]) + "님이 나갔습니다.";
			}
		}

		return answer;
	}

}
