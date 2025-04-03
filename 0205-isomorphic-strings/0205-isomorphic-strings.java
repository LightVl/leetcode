class Solution {
    public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;

        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();

        for (int i = 0; i < s.length(); ++i) {
          
            // If character not seen before, store its 
            // first occurrence index
            if (!m1.containsKey(s.charAt(i))) {
                m1.put(s.charAt(i), i);
            }
            if (!m2.containsKey(t.charAt(i))) {
                m2.put(t.charAt(i), i);
            }

            // Check if the first occurrence indices match
            if (!m1.get(s.charAt(i)).equals(m2.get(t.charAt(i)))) {
                return false;
            }
        }
        return true;
    }
}