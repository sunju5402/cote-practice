import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		int[] nums = {74, 24, 69, 45, 59, 6, 84, 64, 27, 77};
		nums = solution(nums);
		for (int n : nums) {
			System.out.println(n);
		}
	}

	public static int[] solution(int[] nums) {
		int[] result = nums;
		boolean isStable;
		do {
			isStable = true;
			for (int i = 1; i < result.length - 1; i++) {
				if (result[i] < result[i - 1] && result[i] < result[i + 1]) {
					isStable = false;
					result[i]++;
				} else if (result[i] > result[i - 1] && result[i] > result[i + 1]) {
					isStable = false;
					result[i]--;
				}
			}
		} while (!isStable);

		return result;
	}
}
