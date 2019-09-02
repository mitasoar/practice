package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastCommonMultiple_yet2 {
	public static void main(String[] mita) {
		System.out.println(solution(new int[] { 5, 8, 7, 14 }));
	}

	public static int solution(int[] arr) {
		int answer = 1; // 나눠지는 인수에 대해 계속 곱셈을 하려고 변수를 1로 세팅

		Arrays.sort(arr); // 나누는 숫자의 범위를 정하기 위해 정렬하여 제일 큰 숫자를 찾음

		List<Integer> arr1 = new ArrayList<>(); // 배열을 옮겨담아서 나누고 할 예정
		
		for (int a : arr) { // 배열을 리스트에 옮김
			arr1.add(a);
		}

		List<Integer> arr2 = new ArrayList<>(); // 나눈값을 옮기기위한 두번째 리스트
		
		int n = 0; // 인수가 2개이상 적용되는지 확인하기위해 만든 변수
		
		for (int i = 2; i <= arr[arr.length - 1] / 2; i += 2) { // 인수의 범위를 모든 짝수의 인수인 2부터 시작하여 홀수로 확인하려고 2씩 증가하며, 범위는 제일 큰 수의 /2 까지..
			n = 0; // 인수찾기가 적용되는 시점마다 n을 리셋
			if (i == 2) { // 짝수인 경우에만..
				for (int j = 0; j < arr1.size(); j++) { // i라는 인수로 현재 배열에서 2개이상 나눠지는지 확인하는 for문
					if (arr1.get(j) % i == 0) { // 인수의 조건이 맞으면
						n++; // n카운트
						arr2.add(j / i); // 인수를 나눈값을 2에 세팅
					} else { // 인수의 조건이 안맞을때
						arr2.add(j); // 기존 값을 arr2에 세팅
					}
				}
				if (n >= 2) { // i가 인수인 수가 2개 이상일 경우
					answer *= i; // 인수를 곱해줌
					arr1 = arr2; // 인수가 적용됐으므로 arr2의 값을 arr1에 옮김
					arr2.clear(); // 그리고 arr2를 리셋
					i -= 2; // 똑같은 수로 다시 for문이 돌수있게 뺌
					continue; // 다시 반복
				} else { // i가 인수인 수가 2개 미만일 경우
					arr2.clear(); // arr2 리셋
					i -= 1; // 3으로 시작될수있게 1을 뺌 
					continue;
				}
			}
			
			for (int j = 0; j < arr1.size(); j++) { // i라는 인수로 현재 배열에서 2개이상 나눠지는지 확인하는 for문
				if (arr1.get(j) % i == 0) { // 인수의 조건이 맞으면
					n++; // n카운트
					arr2.add(j / i); // 인수를 나눈값을 2에 세팅
				} else { // 인수의 조건이 안맞을때
					arr2.add(j); // 기존 값을 arr2에 세팅
				}
			}
			if (n >= 2) { // i가 인수인 수가 2개 이상일 경우
				answer *= i; // 인수를 곱해줌
				arr1 = arr2; // 인수가 적용됐으므로 arr2의 값을 arr1에 옮김
				arr2.clear(); // 그리고 arr2를 리셋
				i -= 2; // 똑같은 수로 다시 for문이 돌수있게 뺌
				continue; // 다시 반복
			} else { // i가 인수인 수가 2개 미만일 경우
				arr2.clear(); // arr2 리셋
//				i -= 1; 이건 i가 2인경우에만 적용이기에 제외..
				continue;
			}
		}
		
		for (int i = 0; i < arr1.size(); i++) {
			answer *= arr1.get(i);
		}

		return answer;
	}
}
