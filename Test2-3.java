import java.util.ArrayList;
import java.util.Stack;

public class Test3 {
    public static String calculate(String string) {
        Stack<String> stack = new Stack<String>();
        for (String str: string.split("")) {
            ArrayList<String> list = new ArrayList<>();
            String code = "";
            String dup = "";
            if (str.equals("{")) {
                continue;
            } else if (str.equals("}")){
                String s = stack.pop();
                System.out.println(s);
                while(s.toCharArray()[0] < '0' || s.toCharArray()[0] > '9') { // 0이 올 수 있는 경우와, 자연수만 가능할 때 나눠서 해볼 수 있음.
                    list.add(s);
                    s = stack.pop();
                }
                String tmp;
                int size = list.size();
                if (size == 1) {
                    code = list.get(0);
                } else {
                    for (int i = size - 1; i >= 0; i--) {
                        code += list.get(i);
                    }
                }

                int n = Integer.parseInt(s);
                dup = code;
                System.out.println("\n" + n);
                for (int i = 1; i < n; i++) {
                    code += dup;
                }
                System.out.println(code);
                stack.push(code);
            } else {
                stack.push(str);
            }
        }

        String answer = "";

        ArrayList<String> al = new ArrayList<>();
        while (!stack.empty()) {
            al.add(stack.pop());
        }
        for (int i = al.size() - 1; i >= 0 ; i--) {
            answer += al.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(calculate("5{he2{l}o}friend"));
    }
}
