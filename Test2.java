import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test2 {
    public static void main(String[] args) {
        String[] names = {"제로", "베이스", "자바", "스쿨", "자바", "베이스", "베이스", "백엔드", "화이팅"};
        System.out.println(solution(names));
    }

    public static int solution(String[] names) {
        int answer = 0;
        Set<String> set = new HashSet<>(Arrays.asList(names));

//        for (int i = 0; i < names.length; i++) {
//            set.add(names[i]);
//        }

//        boolean[] visited = new boolean[set.size()];
//        for (int i = 0; i < set.size(); i++) {
//            answer += comb(visited, i, set.size(), 4);
//        }
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

class Solution2 {
    public int solution(String[] names) {
        Set<String> set = new HashSet<>(Arrays.asList(names));
        int n = set.size();
        int m = 4;

        int numerator = 1;
        int denominator = 1;
        for (int i = 0; i < m; i++) {
            numerator *= n - i;
            denominator *= (i + 1);
        }

        return numerator / denominator;
    }
}