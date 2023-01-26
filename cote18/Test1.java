import java.util.Arrays;
import java.util.Collections;

public class Test1 {

	public static void main(String[] args) {
		int[] food = {6, 3, 4, 5};
		System.out.println(solution(food));
	}

	public static int solution(int[] food) {
		Integer[] arr = Arrays.stream(food).boxed().toArray(Integer[]::new);
		Arrays.sort(arr, Collections.reverseOrder());

		int cnt = 0;
		int temp = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				cnt += Math.max(temp, arr[i]);
				break;
			}
			cnt += Math.min(temp, arr[i]);
			temp = Math.abs(temp - arr[i]);
		}

		return cnt;
	}

	public static int solution1(int[] food) {
		return (Arrays.stream(food).sum() + 1) / 2;
	}
}
