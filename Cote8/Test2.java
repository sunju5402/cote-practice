// DP 문제 답은 맞다고 나오는데 왜 테스트에서 점수가 안 나오는지 모르겠음...
public class Test2 {
    public static void main(String[] args) {
        int depth = 3;
        int n = 3;
        int[][] blocks = {{5, 6, 2, 6}, {1, 6, 4, 9}, {5, 6, 9, 4}, {55, 14, 21, 14}};
        System.out.println(solution(depth, n, blocks));
    }

    public static int solution(int depth, int n, int[][] blocks) {
        if (blocks == null || blocks.length < 0) {
            return -1;
        }

        int result = blocks[depth][n];

        for (int i = depth - 1; i >= 0; i--) {
            if (n + 1 < blocks[i].length) {
                if (n - 1 >= 0) {
                    result += Math.min(Math.min(blocks[i][n + 1], blocks[i][n]), blocks[i][n - 1]);
                } else {
                    result += Math.min(blocks[i][n + 1], blocks[i][n]);
                }
            } else {
                if (n - 1 >= 0) {
                    result += Math.min(blocks[i][n], blocks[i][n - 1]);
                } else {
                    result += blocks[i][n];
                }
            }
        }

//        int minVal = Integer.MAX_VALUE;
//        for (int i = 0; i < blocks[0].length; i++) {
//            minVal = Math.min(minVal, blocks[0][i]);
//        }
//
//        result += minVal;

        return result;
    }

}
