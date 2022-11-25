import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(solution(132));
    }

    public static String[] solution(int n) {
        String[] answer = new String[5];
        ArrayList<String[]> arr = new ArrayList<>();

        arr.add(0, new String[]{"#####", "#---#", "#---#", "#---#", "#####"});
        arr.add(1, new String[]{"--#--", "--#--", "--#--", "--#--", "--#--"});
        arr.add(2, new String[]{"####", "---#", "####", "#---", "####"});
        arr.add(3, new String[]{"####", "---#", "####", "---#", "####"});
        arr.add(4, new String[]{"#---#", "#---#", "#####", "----#", "----#"});
        arr.add(5, new String[]{"#####", "#----", "#####", "----#", "#####"});
        arr.add(6, new String[]{"#####", "#----", "#####", "#---#", "#####"});
        arr.add(7, new String[]{"#####", "----#", "----#", "----#", "----#"});
        arr.add(8, new String[]{"#####", "#---#", "#####", "#---#", "#####"});
        arr.add(9, new String[]{"#####", "#---#", "#####", "----#", "----#"});

        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                answer = arr.get(Character.getNumericValue(s.charAt(i)));
            } else {
                for (int j = 0; j < answer.length; j++) {
                    answer[j] += " " + arr.get(Character.getNumericValue(s.charAt(i)))[j];
                }
            }
        }

        return answer;
    }
}
