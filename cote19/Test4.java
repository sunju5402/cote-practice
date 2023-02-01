import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Test4 {

	public static void main(String[] args) {
		int[] param = {3, 2, -2, 5, -3};
		System.out.println(solution(param));
	}

	public static int solution(int[] param0) {
		List<Integer> list = Arrays.stream(param0).boxed().collect(Collectors.toList());
		Collections.sort(list);

		int i = 0;
		while(list.get(i) < 0) {
			if (list.contains(-list.get(i))) {
				return -list.get(i);
			}
		}

		return 0;
	}
}
