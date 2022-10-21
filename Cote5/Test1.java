import java.util.Arrays;

public class Test1 {
    public static void main(String[] args) {
        String s = "imfinethankyou";
        String t = "atfhinemnoyuki";
        System.out.println(solution(s, t));
    }

    public static boolean solution(String s, String t) {
        if (s.length() != t.length()) { // 이거 안쓰면 효율성에서 6점 깍임.
            return false;
        }
        char[] arr1 = s.toCharArray();
        Arrays.sort(arr1);


        char[] arr2 = t.toCharArray();
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

}
