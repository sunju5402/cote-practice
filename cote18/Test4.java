public class Test4 {

	public static void main(String[] args) {
		int[] x = {1, 2, 5, 6};
		int[] y = {3, 1, 10, -9};
		int k = 2;
		System.out.println(solution(x, y, k));
	}

	public static int solution(int[] x, int[] y, int k) {
		int max = Integer.MIN_VALUE;
		int p1 = 0;
		int p2 = 1;
		while (p1 < x.length && p2 < x.length) {
			if (x[p2] - x[p1] <= k) {
				max = Math.max(max, y[p1] + y[p2] + (x[p2] - x[p1]));
			} else {
				p1++;
				p2 = p1 + 1;
				continue;
			}
			p2++;

			if (p2 == x.length) {
				p1++;
				p2 = p1 + 1;
			}
		}

		return max;
	}
}
