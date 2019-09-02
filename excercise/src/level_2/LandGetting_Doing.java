package level_2;

public class LandGetting_Doing {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 1, 2, 3, 4 }, { 8, 7, 6, 5 }, { 4, 3, 2, 1 }, { 5, 6, 7, 8 } }));

	}

	static int solution(int[][] land) {
		int answer = 0;
		
		int before = 0;

		for (int i = 0; i < land[0].length; i++) {
			int k = i;
			before = land[0][k];
			for (int j = 1; j < land.length; j++) {
				if (k == 0) {
					int m = 0;
					if (land[j][1] > land[j][2]) {
						m = land[j][1];
						k = 1;
					} else {
						m = land[j][2];
						k = 2;
					}
					
					if (m > land[j][3]) {
						before += m;
					} else {
						before += land[j][3];
						k = 3;
					}
				} else if (k == 1) {
					int m = 0;
					if (land[j][0] > land[j][2]) {
						m = land[j][0];
						k = 0;
					} else {
						m = land[j][2];
						k = 2;
					}
					
					if (m > land[j][3]) {
						before += m;
					} else {
						before += land[j][3];
						k = 3;
					}
				} else if (k == 2) {
					int m = 0;
					if (land[j][1] > land[j][0]) {
						m = land[j][1];
						k = 1;
					} else {
						m = land[j][0];
						k = 0;
					}
					
					if (m > land[j][3]) {
						before += m;
					} else {
						before += land[j][3];
						k = 3;
					}
				} else {
					int m = 0;
					if (land[j][1] > land[j][2]) {
						m = land[j][1];
						k = 1;
					} else {
						m = land[j][2];
						k = 2;
					}
					
					if (m > land[j][0]) {
						before += m;
					} else {
						before += land[j][0];
						k = 0;
					}
				}
			}
			if (before > answer) {
				answer = before;
			}
		}
		return answer;
	}
	
//	static int solution(int[][] land) {
//		int answer = 0; // 정답을 담을 변수
//
//		int b = -1; // 이전 행의 index 변수
//		int c = 0; // 최대값의 index를 담을 변수
//
//		for (int i = 0; i < land.length; i++) { // 전체 이중배열을 반복
//			int a = 0; // i행의 최대값을 담을 변수
//			if (i != land.length - 1) { // 마지막행만 제외
//				int aa = 0; // i행의 최대값을 구하기 위한 변수
//				for (int j = 0; j < land[i].length; j++) { // land[i]의 배열을 반복
//					if (j != b) { // 해당 행의 열이 지난 열과 같지 않을 때
//						boolean f = false; // 최대값이 바뀌었는지 여부를 판단하기 위한 변수
//						for (int k = 0; k < land[i + 1].length; k++) { // land[i + 1]행을 반복
//							if (j != k) { // 열이 겹치지 않을 때
//								if (land[i][j] + land[i + 1][k] > aa) { // i행의 j인덱스값 + 다음행인 i+1행의 k인덱스값이 이전 인덱스값보다 클 때
//									aa = land[i][j] + land[i + 1][k]; // aa에 i행의 j인덱스값 + 다음행인 i+1행의 k인덱스값을 담음
//									f = true; // 최대값 변경을 변수로 표시
//								}
//							}
//							if (f) { // 최대값이 변경되었을 때
//								a = land[i][j]; // a에 최대값인 인덱스값을 담는다
//								c = j; // c에 최대값의 인덱스를 담는다
//							}
//						}
//					}
//				}
//				b = c; // for문을 다 실행하고, b에 해당 열의 최대값 인덱스인 c를 담는다
//			} else { // 행이 마지막행일 때
//				for (int j = 0; j < land[i].length; j++) { // land[i]의 배열을 반복
//					if (j != b) { // 해당 행의 열이 지난 열과 같지 않을 때
//						if (a < land[i][j]) { // 지금 담으려는 값 + 다음행의 같은 인덱스 값이, 이전에 담았던 최대값 + 다음행의 같은 인덱스 값보다 크거나 같으면
//							a = land[i][j]; // a에 최대값인 인덱스값을 담는다
//						}
//					}
//				}
//			}
//			answer += a; // answer에 최대값인 a를 더한다
//		}
//		return answer;
//	}
}
