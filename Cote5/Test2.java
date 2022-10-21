import java.util.ArrayList;
import java.util.Collections;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = {3, 30, 34, 5, 9};

        System.out.println(solution(arr));
    }

    public static String solution(int[] numbers) {
        if (numbers.length == 0 || numbers == null) {
            return "";
        }

        String rlt = "";
        ArrayList<String> str = new ArrayList<>();
        for (int num : numbers) {
            str.add(String.valueOf(num));
        }

        Collections.sort(str, (a, b) -> (b + a).compareTo(a + b));
        if (str.get(0).startsWith("0")) {
            return "0";
        }

        for (String s : str) {
            rlt += s;
        }
        return rlt;
    }
}
