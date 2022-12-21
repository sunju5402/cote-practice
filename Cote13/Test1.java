import java.math.BigDecimal;
import java.text.DecimalFormat;

public class Test1 {
    public static void main(String[] args) {
//        String s = "   +  00051241231004242542514243_41251243";
        String s = "+0";
        System.out.println(solution(s));
    }

    public static int solution(String s) {
        String rs = s.replaceAll(" ", "");
        char sign = rs.charAt(0);
        String intS = "" + sign;

        for (int i = 1; i < rs.length(); i++) {
            if (rs.charAt(i) >= '0' && rs.charAt(i) <= '9') {
                intS += rs.charAt(i);
            } else {
                break;
            }
        }

        intS = new DecimalFormat("0").format(new BigDecimal(intS)); //  intS = intS.replaceAll("^0+", "");
        int result = 0;

        if (sign == '-') {
            if (intS.length() > 11) {
                return Integer.MIN_VALUE;
            }
            if (intS.length() == 10 &&
                    String.valueOf(Integer.MIN_VALUE).compareTo(intS) < 0) {
                return Integer.MIN_VALUE;
            }
//            result = Math.max(Integer.MIN_VALUE, -Integer.parseInt(intS));
        } else {
            if (intS.length() > 11) {
                return Integer.MAX_VALUE;
            }
            if (intS.length() == 10 &&
                    String.valueOf(Integer.MAX_VALUE).compareTo(intS) > 0) {
                return Integer.MAX_VALUE;
            }
//            result = Math.min(Integer.MAX_VALUE, Integer.parseInt(intS));
        }
        result = Integer.parseInt(intS);

        return result;
    }
}
