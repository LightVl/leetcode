class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Array to count occurrences of each letter in the magazine.
        int[] letterCounts = new int[26];
      
        // Populate the letterCounts array with the count of each character in the magazine.
        for (int i = 0; i < magazine.length(); i++) {
            // Increment the count of the current character.
            letterCounts[magazine.charAt(i) - 'a']++;
        }
      
        // Check if the ransom note can be constructed using the letters in the magazine.
        for (int i = 0; i < ransomNote.length(); i++) {
            // Decrement the count of the current character, as it is used in the ransom note.
            if (--letterCounts[ransomNote.charAt(i) - 'a'] < 0) {
                // If any letter in the ransom note is in deficit, return false.
                return false;
            }
        }
      
        // If all letters are accounted for, return true.
        return true;  
    }
}