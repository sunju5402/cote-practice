import java.util.ArrayList;
import java.util.List;

public class Test3 {
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        String s = "2552552551";
        String[] ss = solution(s);

        for (String sss : ss) {
            System.out.println(sss);
        }
    }

    public static String[] solution(String s) {
        if (s == null) {
            return null;
        }

        backTracking(s, "", 0, 0);
        String[] answer = list.toArray(new String[0]);

        return answer;
    }

    public static void backTracking(String s, String ip, int start, int len) {
        if (start == s.length() && len > 3) {
            list.add(ip);
        }

        if (start >= s.length() || len > 3) {
            return;
        }

        for (int i = 1; i < 4; i++) {
            if (start + i > s.length()) {
                break;
            }
            String ss = s.substring(start, start + i);
            if ((ss.startsWith("0") && ss.length() > 1)
                    || Integer.parseInt(ss) < 0 || Integer.parseInt(ss) > 255) {
                continue;
            }

//            ip = ss + (len == 3 ? "" : ".");
            backTracking(s, ip + ss + (len == 3 ? "" : "."),start + i,len + 1);
        }
    }
}

class Solution3 {
    List<String> addresList = new ArrayList<>();

    public String[] solution(String s) {
        solve(s, new ArrayList<>()); // 메모리 재활용
        return addresList.stream()
                .sorted()
                .toArray(String[]::new);
    }

    void solve(String s, List<Integer> dots) {
        int n = dots.size();
        if (n == 3) { // 구분점 3개가 모두 찍힌 경우
            // 마지막 숫자가 유망한지 확인하여 답안에 등록
            if (isPromising(s.substring(dots.get(2)))) {
                addresList.add(makeAddress(s, dots));
            }
            return;
        }

        for (int i = 1; i < 4; i++) { // 구분점 사이에는 1~3문자가 포함
            if (n == 0) { // 첫번째 구분점
                dots.add(i);
                if (i < s.length() && // 점이 문자 내부에 있는지 확인
                        isPromising(s.substring(0, i))) { // 새로 구분된 숫자가 유망한면 진행
                    solve(s, dots);
                }
            } else  { // 2~4번째 구분점
                int lastDot = dots.get(n - 1); // 마지막 점
                int currDot = lastDot + i; // 마지막 구분점을 기준으로 위치
                dots.add(currDot);
                if (currDot < s.length() && // 점이 문자 내부에 있는지 확인
                isPromising(s.substring(lastDot, currDot))) { // 새로 구분된 숫자가 유망하면 진행
                    solve(s, dots);
                }
            }
            dots.remove(n);
        }
    }

    boolean isPromising(String s) {
        if (s.length() == 0) {
            return false;
        }
        if (s.length() > 1 && s.charAt(0) == '0') { // leading zero 이면 안됨.
            return false;
        }
        int n = Integer.parseInt(s);
        if (n >= 0 && n <= 255) {
            return true;
        }
        return false;
    }

    String makeAddress (String s, List<Integer> dots) {
        return s.substring(0, dots.get(0)) + "." +
                s.substring(dots.get(0), dots.get(1)) + "." +
                s.substring(dots.get(1), dots.get(2)) + "." +
                s.substring(dots.get(2));
    }
}
