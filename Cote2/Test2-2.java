import java.util.ArrayList;
import java.util.Stack;

public class Test2 {
    public static void main(String[] args) {
        int[] arr = solution(new int[]{5, 2, 1, 4, 6}, new int[]{6, 1, 0, 4, 4});
//         int[] arr = solution(new int[]{1, 0}, new int[]{});
        for (int n : arr) {
            System.out.print(n + " ");
        }
    }

    public static int[] solution(int[] a, int[] b) {
        int[] answer = {};
        int maxSize = Math.max(a.length, b.length);
        int minSize = Math.min(a.length, b.length);
        ArrayList<Integer> list = new ArrayList<>();

        int total = 0;
        for (int i = 0; i < minSize; i++) {
            total += a[a.length - i - 1] + b[b.length - i - 1];
            total = addList(list, total);
        }

        int dif = maxSize - minSize;
        for (int i = dif - 1; i >= 0; i--) {
            if (maxSize == a.length) {
                total += a[i];
                total = addList(list, total);
            } else {
                total += b[i];
                total = addList(list, total);
            }
        }
        if (total != 0) {
            addList(list, total);
        }

        if (list.size() == 1 && list.get(0) == 0) {
            return answer;
        }
        answer = new int[list.size()];
        reverseSort(list, answer);
        return answer;
    }

    public static int addList(ArrayList<Integer> list, int total) {
        if (total >= 10) {
            list.add(total % 10);
            total /= 10;
        } else {
            list.add(total);
            total = 0;
        }
        return total;
    }

    public static void reverseSort(ArrayList<Integer> list, int[] answer) {
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(list.size() - i - 1);
        }
    }
}
