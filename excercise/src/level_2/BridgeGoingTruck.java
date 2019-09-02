package level_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGoingTruck {

	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int answer = 0;
		
		int busWeight = 0;
		
		List<Integer> bus = new ArrayList<>();
		
		List<Integer> time = new ArrayList<>();
		
		while (true) {
			++answer;
			if (truck_weights.length != 0) busWeight += truck_weights[0];
			if (truck_weights.length != 0 && busWeight <= weight) {
				bus.add(truck_weights[0]);
				truck_weights = Arrays.copyOfRange(truck_weights, 1, truck_weights.length);
				time.add(answer);
			} else if (busWeight > weight) {
				if (truck_weights.length != 0)busWeight -= truck_weights[0];
				if (time.get(0) + bridge_length == answer) {
					time.remove(0);
					busWeight -= bus.get(0);
					bus.remove(0);
					answer--;
				}
				continue;
			}
			
			if (time.get(0) + bridge_length == answer) {
				time.remove(0);
				busWeight -= bus.get(0);
				bus.remove(0);
			}
//			
//			System.out.println("남아있는 트럭들 : " + Arrays.toString(truck_weights));
//			System.out.println("가고있는 버스들 : " + bus);
//			System.out.println("가고있는 버스의 무게 : " + busWeight);
//			System.out.println("버스의 출발시간 : " + time);
//			System.out.println("현재시간 : " + answer);
//			System.out.println();
			if (bus.size() == 0 || time.size() == 0) break;
		}
		
		return answer;
	}

}
