public class Test2 {

	public static void main(String[] args) {
		String[] words = {"zero", "base", "esab", "esabe", "orez"};
		System.out.println(solution(words));
	}

	public static int solution(String[] words) {
		int cnt = 0;
		String word = "";
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				word = words[i] + words[j];
				cnt += checkPalindrome(word);

				word = words[j] + words[i];
				cnt += checkPalindrome(word);
			}
		}

		return cnt;
	}

	public static int checkPalindrome(String word) {
		boolean isSame = true;
		for (int k = 0; k < word.length() / 2; k++) {
			if (word.charAt(k) !=  word.charAt(word.length() - k - 1)) {
				isSame = false;
				break;
			}
		}
		if (isSame) {
			return 1;
		}
		return 0;
	}
}
