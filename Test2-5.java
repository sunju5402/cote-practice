public class Test5 {
    public static void main(String[] args) {
        int[][] arr = {{4, 5, 2, 6, 7,},
                {5, 4, 2, 4, 6,},
                {6, 8, 4, 8, 7},
                {7, 3, 6, 6, 4},
                {5, 0, 4, 1, 5}};
        int[][] a = solution(arr, 3);
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solution(int[][] image, int K) {
        int[][] answer = image;

        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                int total = 0;
                total += image[i][j];
                for (int k = 1; k <= K / 2; k++) {
                    if (i - k >= 0) {
                        if (j - k >= 0) {
                            total += image[i - k][j - k];
                        }
                        if (j + k < image[i].length) {
                            total += image[i - k][j + k];
                        }
                        total += image[i - k][j];
                    }
                    if (i + k < image.length) {
                        if (j - k >= 0) {
                            total += image[i + k][j - k];
                        }
                        if (j + k < image[i].length) {
                            total += image[i + k][j + k];
                        }
                        total += image[i + k][j];
                    }
                    if (j - k >= 0) {
                        total += image[i][j - k];
                    }
                    if (j + k < image[i].length) {
                        total += image[i][j + k];
                    }
                }
                answer[i][j] = total / (K * K);
            }
        }

        return answer;
    }
}
