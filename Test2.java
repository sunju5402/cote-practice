import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        String[] names = {"제", "베", "자바", "스쿨", "자바", "베", "베", "백엔드", "화이팅"};
        System.out.println(solution(names));
    }

    public static int solution(String[] names) {
        int answer = 0;
        Set<String> set = new HashSet<>(Arrays.asList(names));

        answer = comb(set.size(), 4);

        return answer;
    }

    public static int comb(int n, int r) {
        if (n == r || r == 0) {
            return 1;
        } else  {
            return comb(n - 1, r - 1) + comb(n - 1, r);
        }
    }
}
