public class Test1 {

	public static void main(String[] args) {
		String s = "캠브릿지 대학의 연구결과에 따르면";
		String t = "캠릿브지 대학의 연결과구에 따르면";
		System.out.println(solution(s, t));
	}

	public static boolean solution(String s, String t) {
		String[] sArr = s.split(" ");
		String[] tArr = t.split(" ");

		for (int i = 0; i < sArr.length; i++) {
			if (sArr[i].charAt(0) != tArr[i].charAt(0) ||
				sArr[i].charAt(sArr[i].length() - 1) != tArr[i].charAt(tArr[i].length() - 1)) {
				return false;
			}
		}

		return true;
	}
}
