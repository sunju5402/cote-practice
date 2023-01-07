import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Test1 {

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4};
		int k = 3;
		System.out.println(Arrays.toString(solution(nums, k)));
	}

	public static int[] solution(int[] nums, int k) {
		int[] answer = new int[k];

		Map<Integer, Integer> map = new HashMap<>();
		for (int v : nums) {
			if (!map.containsKey(v)) {
				map.put(v, 1);
			} else {
				map.put(v, map.get(v) + 1);
			}
		}
		List<Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		entryList.sort(((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey())));

		for (int i = 0; i < k; i++) {
			answer[i] = entryList.get(i).getKey();
		}

		return answer;
	}

}
