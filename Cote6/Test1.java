import java.util.Arrays;

// 투포인트 문제
public class Test1 {
    public static void main(String[] args) {
        int[] values = {103, 152, 124, 165, 152, 154, 159, 160,
                200, 195, 205, 206, 204, 189, 156};

        System.out.println(Arrays.toString(solution(values)));
    }

    public static int[] solution(int[] values) {
        int[] answer = {0, 0};

        if (values == null || values.length < 2) {
            return new int[]{0, 0};
        }

        int p1 = 0;
        int p2 = 1;
        int cnt = 0;
        int max = 0;

        while (p2 < values.length) {
            if (values[p2 - 1] < values[p2]) {
                cnt++;
            }

            if (max < cnt) {
                max = cnt;
                answer[0] = p1;
                answer[1] = p2;
            }

            if (values[p2 - 1] >= values[p2]) {
                p1 = p2;
                cnt = 0;
            }
            p2++;
        }

        return answer;
    }
}
