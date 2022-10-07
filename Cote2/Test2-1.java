import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{9, 4, 2, 3, 7, 5}));
    }

    public static int solution(int[] numbers) {
        int answer = 0;

        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        for (int n : numbers) {
            min = Math.min(min, n);
        }
        int num = min; // 연속된 숫자인지 확인하기 위한 변수
        for (int n: numbers) {
            if (num != n) {
                answer = num;
                break;
            }
            num++;
        }
        return answer;
    }
}
