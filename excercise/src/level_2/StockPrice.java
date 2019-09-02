package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockPrice {

	public int[] solution(int[] prices) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < prices.length; i++) {
			int num = 0;
			for (int j = i + 1; j < prices.length; j++) {
				num++;
				if (prices[i] > prices[j]) {
					break;
				}
			}
			list.add(num);
		}

		return Arrays.stream(list.toArray(new Integer[0])).mapToInt(i -> i).toArray();
	}
}
