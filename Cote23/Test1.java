public class Test1 {

	public static void main(String[] args) {
		System.out.println(solution(10, 5, 3));
	}

	public static int solution(int L, int U, int D) {
		int height = U;
		int cnt = 1;

		while (height < L) {
			height -= D;
			height += U;
			cnt++;
		}

		return cnt;
	}
}
