import java.util.Arrays;
// 이진탐색 문제 - 왜 틀렸는지 아직 모름... 정답은 통과했는데 채점이...
public class Test5 {
    public static void main(String[] args) {
        int N = 2;
        int M = 20;
        int[] fry = {3, 6};
        int[] clean = {2, 1};

        System.out.println(solution(N, M, fry, clean));
    }

    public static int solution(int N, int M, int[] fry, int[] clean) {
        if (N == 0 || fry == null || fry.length == 0) {
            return -1;
        }

        int[] arr = fry;
        Arrays.sort(arr);

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for (int i = 0; i < N; i++) {
            if (max <= fry[i]) {
                max = fry[i];
                idx = i;
            }
        }

        int answer = Integer.MAX_VALUE;
        int left = arr[0];
        int right = (arr[arr.length - 1] + clean[idx]) * (M - 1) + arr[arr.length - 1];
        int cnt = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            cnt = 0;
            for (int i = 0; i < N; i++) {
                int cal = (fry[i] + clean[i]);
                cnt += mid / cal;
                if (fry[i] <= (mid % cal)) {
                    cnt++;
                }
                if (cnt >= M) {
                    break;
                }
            }

            if (cnt < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}
