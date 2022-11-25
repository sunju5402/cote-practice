import java.util.Arrays;

public class Test4 {
    public static void main(String[] args) {
        int[] param = {3, 4, 1, 1, 0, 3};
//        int[] param = {2, 3, 5, 2, 0, 2, 1, 1, 0, 0, 4};
        System.out.println(solution(param));
    }

    public static boolean solution(int[] param0) {
        boolean isOk;

        if (param0.length == 1) { // 무조건 자기 자신은 접근이 가능하므로 true
            return true;
        }

        for (int i = 0; i < param0.length - 1; i++) {
            if (i + param0[i] >= param0.length - 1) {
                isOk = solution(Arrays.copyOfRange(param0, 0, param0.length - 1));

                if (!isOk) {
                    return false;
                }
                return true;
            }
        }

        return false;
    }
}
