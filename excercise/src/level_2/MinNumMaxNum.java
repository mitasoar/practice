package level_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinNumMaxNum {

	public String solution(String s) {
		String answer = "";
		
		String[] strs = s.split(" ");
		
		List<Integer> nums = new ArrayList<>();
		
		for (int i = 0; i < strs.length; i++) {
			nums.add(Integer.parseInt(strs[i]));
		}
		
		Collections.sort(nums);

		return nums.get(0) + " " + nums.get(nums.size() - 1);
	}

}
