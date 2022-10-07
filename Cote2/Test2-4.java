import java.util.LinkedList;
import java.util.Queue;

public class Test4 {
    public static void main(String[] args) {
        int delay = 3;
        int capacity = 5;
        int[] times = {3, 2, 0, 0, 2, 3, 0, 0, 2, 2, 5};
//         int[] times = {2, 2, 0, 4, 2, 3, 0, 0, 1, 2, 5, 0, 3, 4, 0};
        System.out.println(solution(delay, capacity, times));
    }

    public static int solution(int delay, int capacity, int[] times) {
        int answer = 0;
        int currentQueue = 0;
        int total = 0;
        int delNum = 0; // 지워야할 queue size
        for (int i = 0; i < times.length; i++) {
            total += times[i];
            delNum = total / delay;
            currentQueue = Math.max(0, currentQueue - delNum);
            if (currentQueue == capacity) {
                answer++;
            } else {
                currentQueue++;
            }
            total %= delay;
        }
        return answer;
    }
}
