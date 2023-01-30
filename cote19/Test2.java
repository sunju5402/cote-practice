import java.util.regex.Pattern;

public class Test2 {

	public static void main(String[] args) {
		String param = "zer0Bas3";
		System.out.println(solution(param));
	}

	public static boolean solution(String param0) {
		String pattern = "(?=.*[0-9])(?=.*[A-Z]).{5,}";

		return Pattern.matches(pattern, param0);
	}
}
