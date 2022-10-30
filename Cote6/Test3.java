import java.util.ArrayList;
import java.util.Arrays;

public class Test3 {
    public static void main(String[] args) {
        String[] ingredients = {"생닭", "인삼", "소주", "대추"};
//        String[] ingredients = {"우유", "시리얼"};
        String[] items = {"물", "인삼", "커피", "생닭", "소주", "사탕", "생닭", "대추", "쌀"};
//        String[] items = {"우유", "물", "위스키", "막걸리", "소주", "김치냉장고", "시리얼"};
        System.out.println(solution(ingredients, items));
    }

    public static int solution(String[] ingredients, String[] items) {
        if (ingredients == null || items == null || ingredients.length == 0
        || items.length == 0) {
            return 0;
        }

        int p1 = 0;
        int p2 = 0;
        int cnt = 0;
        int min = Integer.MAX_VALUE;

        ArrayList<String> list = new ArrayList<>(Arrays.asList(ingredients));
        ArrayList<String> list2 = new ArrayList<>();

        while  (p2 < items.length) {
//            if (cnt == 0 && list.contains(items[p2])) {
//                p1++;
////                list2.add(items[p2]);
//                cnt++;
//                continue;
//            }
            if (cnt == 0 && !list.contains(items[p1]) && p1 < p2) {
                p1++;
                continue;
            }

            if (list.contains(items[p2])) {
                if (!list2.contains(items[p2])) {
                    if (cnt == 0) {
                        p1 = p2;
                    }
                    list2.add(items[p2]);
                    cnt++;
                }
            }

            if (list2.size() == ingredients.length) {
                cnt = p2 - p1 + 1;
                min = Math.min(cnt, min);
//                p2 = p1++;
//                p1++;
                list2.remove(0);
                cnt = 0;

            }
            p2++;
        }

        return min;
    }
}
