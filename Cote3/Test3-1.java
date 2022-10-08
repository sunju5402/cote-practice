import java.util.Arrays;

// 그래프 문제 (유향 그래프) 
public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(3, new int[][]{{1, 3}, {2, 3}}));
    }

    public static int solution(int N, int[][] trust) {
        int[] arr = new int[N + 1];

        for (int i = 0; i < trust.length; i++) {
            arr[trust[i][1]]++;
            arr[trust[i][0]]--;
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == N - 1) {
                return i;
            }
        }
        return -1;
    }
}
