import java.util.Arrays;

// 분할정복
public class Test1 {
//    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        int[][] img = {{0, 0, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1}};
        System.out.println(solution(img));
    }

    public static String solution(int[][] img) {
        StringBuilder sb = new StringBuilder();
        if (img == null) {
            return null;
        }

//        int sum = 0;
//        for (int i = 0; i < img.length; i++) {
//            sum += Arrays.stream(img[i]).sum();
//        }
//
//        if (sum == 0) {
//            return "0";
//        }
        if (oneway(img, 0, 0, img.length) == 0) {
            return "0";
        }
        if (oneway(img, 0, 0, img.length) == 1) {
            return "1";
        }

//        if (sum == Math.pow(img.length, 2)) {
//            return "1";
//        }

       return quadTree(img, 0, 0, img.length, sb);
    }

    public static String quadTree(int[][] img, int n, int m, int size, StringBuilder sb) {
        if (isZip(img, n, m, size)) {
            sb.append(img[n][m]);
            return sb.toString();
        }

        int len = size / 2;
        sb.append("(");
        // 좌측상단
        quadTree(img, n, m, len, sb);
        // 우측상단
        quadTree(img, n, m + len, len, sb);
        //좌측하단
        quadTree(img, n + len, m, len, sb);
        //우측하단
        quadTree(img, n + len, m + len, len, sb);
        sb.append(")");

        return sb.toString();
    }

    public static boolean isZip(int[][] img, int n, int m, int size) {
        for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (img[i][j] != img[n][m]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int oneway(int[][] img, int n, int m, int size) {
        for (int i = n; i < n + size; i++) {
            for (int j = m; j < m + size; j++) {
                if (img[i][j] != img[n][m]) {
                    return -1;
                }
            }
        }
        return img[n][m];
    }
}
