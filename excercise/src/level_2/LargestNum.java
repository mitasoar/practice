package level_2;

import java.util.*;

public class LargestNum {

	public static void main(String[] mita) {
		System.out.println(solution(new int[] { 59, 81, 951, 51, 35, 13 }));
//		System.out.println(solution(new int[] { 0, 0, 0, 1000 }));
//		System.out.println(solution(new int[] { 0, 1000, 0 }));
//		System.out.println(solution(new int[] { 0, 0, 0, 0 }));
//		System.out.println(solution(new int[] { 5, 546 }));
//		System.out.println(solution(new int[] { 40, 403 }));
//		System.out.println(solution(new int[] { 40, 405 }));
//		System.out.println(solution(new int[] { 40, 404 }));
//		System.out.println(solution(new int[] { 12, 121 }));
//		System.out.println(solution(new int[] { 2, 22, 223 }));
//		System.out.println(solution(new int[] { 21, 212 }));
//		System.out.println(solution(new int[] { 41, 415 }));
//		System.out.println(solution(new int[] { 2, 22 }));
//		System.out.println(solution(new int[] { 70, 0, 0, 0 }));
//		System.out.println(solution(new int[] { 12, 1213 }));
		
	}

	public static String solution(int[] numbers) {
		StringBuffer answer = new StringBuffer();

//		List<String> nums = new ArrayList<>();
//
//		for (int num : numbers) {
//			nums.add(String.valueOf(num));
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//			for (int j = i + 1; j < nums.size(); j++) {
//				if (nums.get(i).charAt(0) < nums.get(j).charAt(0)) {
//					nums.add(nums.get(i));
//					nums.remove(i);
//					i -= 1;
//					break;
//				} else if (nums.get(i).charAt(0) == nums.get(j).charAt(0)) {
//					if (Integer.parseInt(nums.get(i) + nums.get(j)) < Integer.parseInt(nums.get(j) + nums.get(i))) {
//						nums.add(nums.get(i));
//						nums.remove(i);
//						i -= 1;
//						break;
//					}
//				}
//			}
//		}
//
//		for (int i = 0; i < nums.size(); i++) {
//			answer += nums.get(i);
//		}
		
		String[] nums = new String[numbers.length];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = numbers[i] + "";
		}
		
		Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
		
//		for (int i = 0; i < nums.length; i++) {
//			for (int j = 0; j < nums.length - 1; j++) {
//				if (Integer.parseInt(nums[j] + nums[j+1]) < Integer.parseInt(nums[j+1] + nums[j])) {
//					String str = nums[j];
//					nums[j] = nums[j+1];
//					nums[j+1] = str;
//				}
//			}
//		}
		
		for (String str : nums) answer.append(str);
		
		if (answer.substring(0, 1).equals("0")) return "0";

		return answer.toString();
	}

}
