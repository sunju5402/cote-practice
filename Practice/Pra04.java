import java.util.ArrayList;

public class Pra04 {
    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }

    public static int solution(String dirs) {
        int answer = dirs.length();
        ArrayList<Integer> xList = new ArrayList<>();
        ArrayList<Integer> yList = new ArrayList<>();

        xList.add(0);
        yList.add(0);

        for (int i = 0; i < dirs.length(); i++) {
            if (dirs.charAt(i) == 'U') {
                xList.add(xList.get(i));
                yList.add(yList.get(i) + 1);
            } else if (dirs.charAt(i) == 'D') {
                xList.add(xList.get(i));
                yList.add(yList.get(i) - 1);
            } else if (dirs.charAt(i) == 'L') {
                xList.add(xList.get(i) - 1);
                yList.add(yList.get(i));
            } else {
                xList.add(xList.get(i) + 1);
                yList.add(yList.get(i));
            }
        }

        for (int i = 0; i < xList.size(); i++) {
            System.out.println(xList.get(i) + "," + yList.get(i));
        }
        return answer;
    }
}
