import java.util.Arrays;
import java.util.OptionalInt;

public class Test2 {
    public static void main(String[] args) {
        int[] votes = {1, 4, 2, 2, 2, 3, 2, 2, 1};
        System.out.println(solution(votes));
    }

    public static int solution(int[] votes) {
        if (votes == null) {
            return -1;
        }

//        Arrays.sort(votes);
        int max = Arrays.stream(votes).max().getAsInt();
        int[] candidate = new int[max + 1];
        for (int i = 0; i < votes.length; i++) {
            candidate[votes[i]]++;
            if (candidate[votes[i]] >= Math.ceil(votes.length / 2)) {
                return votes[i];
            }
        }

        return -1;
    }
}
