public class Pra05 {
    public static void main(String[] args) {
        System.out.println(solution(16, 4, 16));
    }

    public static int solution(int n, int a, int b)
    {
        int answer = 0;
        int num = Math.abs(a - b);
        int totalGameNum = 0;

        while (n > 1) {
            totalGameNum++;
            n /= 2;
        }

        int aa = 0;
        int bb = 0;

        for (int i = 0; i < totalGameNum; i++) {
            if (a > Math.pow(2, i) && a <= Math.pow(2, i + 1)) {
                aa = i + 1;
            }
            if (b > Math.pow(2, i) && b <= Math.pow(2, i + 1)) {
                bb = i + 1;
            }
        }
        answer = Math.max(aa, bb);
        return answer;
    }
}
