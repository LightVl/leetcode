public class Main {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";
        for (char a : magazine.toCharArray()) {
            ransomNote = ransomNote.replaceFirst(String.valueOf(a), "");
            System.out.println(ransomNote);
        }
        if (ransomNote.equals("")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
