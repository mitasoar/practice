package level_2;

import java.util.*;

public class MoreSpicy {
	public static void main(String[] args) {
//		System.out.println(solution(new int[] { 1, 2, 3, 4, 5, 6 }, 50));
		PriorityQueue<Integer> sco = new PriorityQueue<>();
		sco.add(1);
		sco.add(1);
		sco.add(2);
		sco.add(3);
		sco.add(4);
	}

	public static int solution(int[] scoville, int K) {
		int answer = 0;
		
		PriorityQueue<Integer> sco = new PriorityQueue<>();
		
		for (int i : scoville) sco.add(i);
		
		while (true) {
			int i = sco.poll();
			if (i < K) {
				if (sco.size() < 2) return -1;
				sco.add(i + sco.poll()*2);
				answer++;
				continue;
			}
			return answer;
		}
		
//		int answer = 0;
//        
//        List<Integer> list = new ArrayList<>();
//        
//        for (int i : scoville) if (i < K) list.add(i);
//		
//		while (true) {
//			Collections.sort(list);
//			if (list.get(0) < K) {
//                if (list.size() < 2) return -1;
//                list.add(list.get(0) + list.get(1) * 2);
//				list.remove(0);
//                list.remove(0);
//				answer++;
//				continue;
//			}
//			return answer;
//		}
	}

}
