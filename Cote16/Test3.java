import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test3 {

	public static void main(String[] args) {
		int[] nums = {18, 36, 72, 16, 52};
		System.out.println(solution(nums));
	}

	public static int solution(int[] nums) {
		int[] arr = Arrays.stream(nums)
			.boxed().sorted(Collections.reverseOrder())
			.mapToInt(Integer::intValue).toArray();

		List<Integer> list = new ArrayList<>();;
		for (int i = 0; i < arr.length; i++) {
			list.add(Arrays.stream(Stream.of(String.valueOf(arr[i])
					.split(""))
				.mapToInt(Integer::parseInt).toArray()).sum());
		}

		int j = 0;
		int count = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			count = Collections.frequency(list, list.get(i));
			if (count <= 1) {
				continue;
			} else if (count == 2) {
				j = list.lastIndexOf(list.get(i));
				max = Math.max( max, arr[i] + arr[j]);
			} else {
				for (int k = i + 1; k < list.size(); k++) {
					if (list.get(i) == list.get(k)) {
						j = k;
						max = Math.max(max, arr[i] + arr[j]);
					}
				}
			}
		}

		return max == Integer.MIN_VALUE ? -1 : max;
	}

}
