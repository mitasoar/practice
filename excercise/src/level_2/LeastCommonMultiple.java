package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeastCommonMultiple {
	public static void main(String[] mita) {
		System.out.println(solution(new int[] { 2,3,15,25 }));
	}

	public static int solution(int[] arr) {
		int answer = 1; // 나눠지는 인수에 대해 계속 곱셈을 하려고 변수를 1로 세팅

		Arrays.sort(arr); // 나누는 숫자의 범위를 정하기 위해 정렬하여 제일 큰 숫자를 찾음

		List<Integer> list = new ArrayList<>(); // 배열을 옮겨담아서 나누고 할 예정
		
		int n = 0; // 인수가 2개이상 적용되는지 확인하기위해 만든 변수
		
		for (int i = 2; i <= arr[arr.length - 1]; i += 2) { // 인수의 범위를 모든 짝수의 인수인 2부터 시작하여 홀수로 확인하려고 2씩 증가하며, 범위는 제일 큰 수 까지..
			n = 0; // 인수찾기가 적용되는 시점마다 n을 리셋
			if (i == 2) { // 짝수인 경우에만..
				for (int j : arr) { // i라는 인수로 현재 배열에서 2개이상 나눠지는지 확인하는 for문
					if (j % i == 0) { // 인수의 조건이 맞으면
						n++; // n카운트
						list.add(j / i); // 인수를 나눈값을 list에 세팅
					} else { // 인수의 조건이 안맞을때
						list.add(j); // 기존 값을 list에 세팅
					}
				}
				if (n >= 2) { // i가 인수인 수가 2개 이상일 경우
					answer *= i; // 인수를 곱해줌
					arr = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
					// 인수가 적용됐으므로 list의 값을 배열에 적용
					Arrays.sort(arr); // 제일 큰 수를 찾기위해 다시 정렬
					list.clear(); // 그리고 list를 리셋
					i -= 2; // 똑같은 수로 다시 for문이 돌수있게 뺌
					continue; // 다시 반복
				} else { // i가 인수인 수가 2개 미만일 경우
					list.clear(); // list를 리셋
					i -= 1; // 3으로 시작될수있게 1을 뺌 
					continue;
				}
			}
			
			for (int j : arr) { // i라는 인수로 현재 배열에서 2개이상 나눠지는지 확인하는 for문
				if (j % i == 0) { // 인수의 조건이 맞으면
					n++; // n카운트
					list.add(j / i); // 인수를 나눈값을 list에 세팅
				} else { // 인수의 조건이 안맞을때
					list.add(j); // 기존 값을 list에 세팅
				}
			}
			
			if (n >= 2) { // i가 인수인 수가 2개 이상일 경우
				answer *= i; // 인수를 곱해줌
				arr = Arrays.stream(list.toArray(new Integer[0])).mapToInt(Integer::intValue).toArray();
				// 인수가 적용됐으므로 list의 값을 배열에 적용
				Arrays.sort(arr); // 제일 큰 수를 찾기위해 다시 정렬
				list.clear(); // 그리고 list를 리셋
				i -= 2; // 똑같은 수로 다시 for문이 돌수있게 뺌
				continue; // 다시 반복
			} else { // i가 인수인 수가 2개 미만일 경우
				list.clear(); // list 리셋
				continue;
			}
		}
		
		for (int i : arr) {
			answer *= i;
		}

		return answer;
	}
}
