import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "aab";
        List<Character> chars = ransomNote.chars()
                .mapToObj(e->(char)e).collect(Collectors.toList());
        System.out.println(chars.size());
        for (char a : magazine.toCharArray()) {
            if(chars.size() > 0) {
                for (Character b : chars) {
                    if (b.charValue() == a) {
                        chars.remove(b);
                        System.out.println(chars.size());
                        break;
                    }
                }
            }
        }
        if(chars.size() ==0) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
