import java.util.Arrays;

// greedy 문제
public class Test2 {
    public static void main(String[] args) {
        int[] amount = {7, 10, 4, 5};
        int[] value = {5, 4, 3, 1};
        int[] stomach = {4, 6, 2, 8};

        System.out.println(solution(amount, value, stomach));
    }

    public static int solution(int[] amount, int[] value, int[] stomach) {
        int answer = 0;

        if (amount == null || value == null || stomach == null) {
            return answer;
        }
        if (amount.length != value.length ||
        Arrays.stream(amount).sum() < Arrays.stream(stomach).sum()) {
            return answer;
        }

        int total = Arrays.stream(stomach).sum();
        int price = 0;
        int cnt = 0;

        for (int i = 1; i < amount.length; i++) {
            if (cnt < total) {
                if (amount[0] >= stomach.length) {
                    amount[0] -= stomach.length;
                    price += stomach.length * value[0];
                    cnt += stomach.length;
                }
                if (cnt + amount[i] <= total) {
                    price += amount[i] * value[i];
                    cnt += amount[i];
                } else {
                    price += (total - cnt) * value[i];
                    cnt += (total - cnt);
                    System.out.println(price);
                }
            }
        }
        answer = price;

        return answer;
    }
}
