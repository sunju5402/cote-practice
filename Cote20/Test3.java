import java.util.Arrays;
import java.util.Comparator;

public class Test3 {

	public static void main(String[] args) {
		int[][] activity = {{0, 5}, {2, 6}, {3, 5}, {7, 10}, {5, 9}, {13, 15}};
		System.out.println(solution(activity));
	}

	public static int solution(int[][] activity) {
		Arrays.sort(activity, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});

		int cnt = 0;
		boolean[] picked = new boolean[activity.length];
		int pickedCnt = 0;
		int preEndTime = 0;

		while (true) {
			preEndTime = 0;
			for (int i = 0; i < activity.length; i++) {
				if (!picked[i] && preEndTime <= activity[i][0]) {
					preEndTime = activity[i][1];
					picked[i] = true;
					pickedCnt++;
				}
			}
			cnt++;

			if (pickedCnt == picked.length) {
				break;
			}
		}

		return cnt;
	}
}
