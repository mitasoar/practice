package level_2;

public class SkillTree {

	public static void main(String arg[]) {

	}

	public static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			int[] a = new int[skill.length()];
			int count = 0;
			for (int j = 0; j < skill.length(); j++) {
				a[count] = 1;
				for (int k = 0; k < skill_trees[i].length(); k++) {
					if (skill.charAt(j) == skill_trees[i].charAt(k))
						break;
					a[count]++;
				}
				if (count != 0) {
					if (a[count] < a[count - 1])
						break;
				}
				count++;
			}
			boolean b = true;
			for (int l = 0; l < a.length - 1; l++) {
				if (a[l] == 0) {
					b = false;
					break;
				} else {
					if (a[l] > a[l + 1]) {
						b = false;
						break;
					}
				}
			}
			if (b == true)
				answer++;
		}
		return answer;
	}

}
