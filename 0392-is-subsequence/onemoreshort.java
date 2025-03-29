import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String s = "acb";
        String t = "ffaasdasdcasdasdb2d";
        List<Character> chars = s.chars().mapToObj(e->(char)e).collect(Collectors.toList());
        String chString = chars.stream().map(String::valueOf).collect(Collectors.joining(".*", ".*", ".*"));
        System.out.println(Pattern.matches(chString,t));
    }
}
