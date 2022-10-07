public class Main {
    public static void main(String[] args) {
        System.out.println(solution(1, 100));
    }

    public static int solution(int n, int m) {
        int answer = 0;

        String num;
        boolean isPalindrome;
        for (int i = n; i <= m; i++) {
            isPalindrome = true;
            num = String.valueOf(i);
//            if (num.length() > 1) {
                for (int j = 0; j < num.length(); j++) {
                    if (num.charAt(j) != num.charAt(num.length() - j - 1)) {
                        isPalindrome = false;
                        break;
                    }
                }
                if (isPalindrome) {
                    answer++;
                }
//            } else  {
//                answer++;
//            }

        }

        return answer;
    }
}
