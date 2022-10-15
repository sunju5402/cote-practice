import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Test1 {
    public static void main(String[] args) {
        String[] titles = {"아모르파티", "아기상어", "올챙이와개구리", "산다는건"};
        String[] lyrics = {"산다는게다그런거지누구빈손으로와", "아기상어뚜루루", "개울가에올챙이", "산다는건다그런거래요"};
        String[] problems = {"산다", "아기상어", "올챙이"};
        String[][] s = solution2(titles, lyrics, problems);
        for (int i = 0; i < s.length; i++) {
            for (int j = 0; j < s[i].length; j++) {
                System.out.print(s[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String[][] solution(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];

        for (int i = 0; i < problems.length; i++) {
            int size = problems[i].length();
            int idx = 0;
            ArrayList<String> arr = new ArrayList<>();
            for (int j = 0; j < lyrics.length; j++) {
                boolean isSame = true;
                for (int k = 0; k < size; k++) {
                    if (lyrics[j].charAt(k) != problems[i].charAt(k)) {
                        isSame = false;
                        break;
                    }
                }

                if (isSame) {
                    arr.add(titles[j]);
                }
            }
            answer[i] = arr.toArray(new String[0]);
        }

        return answer;
    }

    public static String[][] solution2(String[] titles, String[] lyrics, String[] problems) {
        String[][] answer = new String[problems.length][];

        Trie4 trie = new Trie4();
        for (int i = 0; i < lyrics.length; i++) {
            trie.insert(lyrics[i], i);
        }

        for (int i = 0; i < problems.length; i++) {
            String s = trie.search(problems[i]);
            ArrayList<String> list = new ArrayList<>();
            if (s != null) {
                if (!s.equals("")) {
                    for (String idx : s.split(" ")) {
                        if (!idx.equals(" ")) {
                            list.add(titles[Integer.parseInt(idx)]);
                        }
                    }
                }
            }
            answer[i] = list.toArray(new String[0]);
        }

        return answer;
    }
}

class Node4 {
    HashMap<Character, Node4> child;
    boolean isTerminal;
    String idx;


    public Node4() {
        this.child = new HashMap<>();
        this.isTerminal = false;
        this.idx = "";
    }
}

class Trie4 {
    Node4 root;

    public Trie4() {
        this.root = new Node4();
    }

    public void insert(String str, int idx) {
        Node4 cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            cur.child.putIfAbsent(c, new Node4()); // c로 시작하는 게 없으면 새 노드 만들어
            cur.idx += String.valueOf(idx) + " ";
            cur = cur.child.get(c);

            if (i == str.length() - 1) {
                cur.isTerminal = true;
                return;
            }
        }
    }

    public String search(String str) {
        Node4 cur = this.root;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (cur.child.containsKey(c)) {
                cur = cur.child.get(c);
            } else {
                return null;
            }
        }
        return cur.idx;
    }
}
