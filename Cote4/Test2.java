public class Test2 {
    public static void main(String[] args) {
        String[] words = {"hello", "hell", "good", "goose", "children", "card", "teachable"};
        String[] queries = {"hell*", "goo*", "*able", "qua*"};
        int[] a = solution(words, queries);

        for (int n : a) {
            System.out.print(n + " ");
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int size = queries[i].length();
            for (int j = 0; j < words.length; j++) {
                boolean isSame = true;
                if (queries[i].charAt(size - 1) == '*') {
                    for (int k = 0; k < size - 1; k++) {
                        if (queries[i].charAt(k) != words[j].charAt(k)) {
                            isSame = false;
                            break;
                        }
                    }
                } else {
                    for (int k = 0; k < size - 1; k++) {
                        if (queries[i].charAt(size - k - 1) != words[j].charAt(words[j].length() - k - 1)) {
                            isSame = false;
                            break;
                        }
                    }
                }

                if (isSame) {
                    answer[i]++;
                }
            }
        }

        return answer;
    }
}
