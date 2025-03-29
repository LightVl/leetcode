import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ahbgctttb";
        StringBuilder sb = new StringBuilder();
        for (char a: s.toCharArray()) {
            sb.append(".");
            sb.append("*");
            sb.append(a);
        }
        sb.append(".");
        sb.append("*");
        System.out.println(Pattern.matches(sb.toString(),t));
    }
}
