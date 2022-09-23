import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }
    public static int solution(int n) {
        int answer = 0;

        boolean isPrime;
        for (int i = 2; i < n; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                answer++;
            }
        }
        return answer;
    }
}
