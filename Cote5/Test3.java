import java.util.Arrays;
// 이진탐색 
public class Test3 {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 3, 4, 5, 12, 15, 14, 12, 11};

        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int left = 1;
        int right = arr.length - 2;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (arr[mid] < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
