public class Test3 {
    public static void main(String[] args) {
        System.out.println(solution(5));
    }

    public static int solution(int N) {
        int answer = 0;
        int cupN = 0; // 세로가 2인 것의 개수

        if (N % 2 != 0) { // 홀수일때
            for (int i = 1; i <= N; i += 2) {
                cupN = (N - i) / 2;
//                cupN /= 2;
                answer += comb(i + cupN, i);
            }
        } else { // 짝수일때
            answer = 1;
            for (int i = 2; i <= N; i += 2) {
                cupN = (N - i) / 2;
//                cupN /= 2;
                answer += comb(i + cupN, i);
            }
        }

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
