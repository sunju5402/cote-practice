import java.util.Arrays;
// 이진 탐색 문제
public class Test4 {
    public static void main(String[] args) {
        int[] branches = {6, 7, 10, 16, 12};
        int N = 10;

        System.out.println(solution(N, branches));
    }
    public static int solution(int N, int[] branches) {
        if (branches == null || branches.length == 0 || N == 0) {
            return -1;
        }
        Arrays.sort(branches);

        int answer = Integer.MIN_VALUE;
        int left = 1;
        int right = branches[branches.length - 1];
        int cnt = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            cnt = 0;
            for (int i = 0; i < branches.length; i++) {
                cnt += branches[i] / mid;
                if (cnt >= N) {
                    break;
                }
            }

            if (cnt < N) {
                right = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
        }

        if (answer == Integer.MIN_VALUE) {
            return -1;
        }

        return answer;
    }
}
