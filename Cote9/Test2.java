// -4 point
public class Test2 {
    public static void main(String[] args) {
        System.out.println(solution(83524));
    }

    public static int solution(int num) {
        char[] c = String.valueOf(num).toCharArray();

        int max = Character.getNumericValue(c[0]);
        int maxIdx = 0;
        for (int i = 1; i < c.length; i++) {
            if (max < Character.getNumericValue(c[i])) {
                max = Character.getNumericValue(c[i]);
                maxIdx = i;
            }
        }

        boolean[] isMax = new boolean[c.length];
        int cnt = 0;
        int lastMaxIdx = 0;
        for (int i = 0; i < c.length; i++) {
            if (Character.getNumericValue(c[i]) == max) {
                isMax[i] = true;
                cnt++;
                lastMaxIdx = i;
            }
        }

        if (maxIdx == 0) {
            if (cnt == 1) {
                if (c.length == 1) {
                    return Integer.parseInt(String.valueOf(c));
                }
                String result = String.valueOf(c[0]);
                result += solution(Integer.parseInt(String.valueOf(c, 1, c.length - 1)));
                return Integer.parseInt(result);
            } else {
                for (int i = 0; i < isMax.length - 1; i++) {
                    if (isMax[i] != isMax[i + 1]) {
                        char tmp = c[lastMaxIdx];
                        c[lastMaxIdx] = c[i + 1];
                        c[i + 1] = tmp;
                        break;
                    }
                }
            }
        } else {
            if (cnt == 1) {
                char tmp = c[maxIdx];
                c[maxIdx] = c[0];
                c[0] = tmp;
            } else {
                char tmp = c[lastMaxIdx];
                c[lastMaxIdx] = c[0];
                c[0] = tmp;
            }
        }

        return Integer.parseInt(new String(c));
    }
}
