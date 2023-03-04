public class Test2 {

	public static void main(String[] args) {
		String s = "i want to study more";
		System.out.println(solution(s, 7, 7));
	}

	public static int solution(String s, int M, int N) {
		String[] strings = s.split(" ");

		int cnt = 0;
		int total = N;
		int j = 0;
		for (int i = 0; i < M; i++) {
			for (; j < strings.length; j++) {
				if (total - strings[j].length() >= 0) {
					total -= strings[j].length();
					total -= 1;
				} else {
					break;
				}
			}
			if (j == strings.length) {
				cnt++;
				j = 0;
				i--;
			} else {
				total = N;
			}
		}

		return cnt;
	}
}
