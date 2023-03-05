public class Test1 {

	public static void main(String[] args) {
		int[] damages = {5, 3, 6, 2, 4};
		int shield = 4;
		System.out.println(solution(damages, shield));
	}

	public static int solution(int[] damages, int shield) {
		int result = 0;

		for (int n : damages) {
			if (n > shield) {
				result += n - shield;
			}
		}

		return result + 1;
	}
}
