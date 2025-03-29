import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ffaasdasdcasdasdb2d";
        s=s.replaceAll("(?=.)", ".*");
        StringBuilder sb = new StringBuilder(s);
        sb.append(".*");
        System.out.println(Pattern.matches(sb.toString(),t));
    }
}
