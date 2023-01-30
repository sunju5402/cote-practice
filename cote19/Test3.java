import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		int[] param = {1, 5, 6, 4};
		System.out.println(solution(param));
	}

	public static int solution(int[] param0) {
		int n = Arrays.stream(param0).max().getAsInt();
		return n - param0.length;
	}
}
