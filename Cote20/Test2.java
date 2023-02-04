import java.util.HashMap;
import java.util.Map;

public class Test2 {

	public static void main(String[] args) {
		int[][] x = {{0, 1}, {3, 3}, {5, 2}, {6, 4}};
		int[][] y = {{2, 5}, {5, 4}, {6, 2}};
		System.out.println(solution(x, y));
	}

	public static int solution(int[][] x, int[][] y) {
		int total = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int[] arr : x) {
			map.put(arr[0], arr[1]);
		}

		for (int[] arr : y) {
			if(map.containsKey(arr[0])) {
				total += map.get(arr[0]) * arr[1];
			}
		}

		return total;
	}
}
