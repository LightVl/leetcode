class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
            for (char a : magazine.toCharArray()) {
            ransomNote = ransomNote.replaceFirst(String.valueOf(a), "");
        }
        if (ransomNote.equals("")) {
            return true;
        } else {
            return false;
        }    
    }
}