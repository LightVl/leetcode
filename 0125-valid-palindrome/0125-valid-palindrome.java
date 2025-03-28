class Solution {
    public boolean isPalindrome(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.toLowerCase();
        System.out.println(s);
        int i = 0;
        int j = s.length()-1;
        while (i!=s.length()/2) {
            if (s.charAt(i)!=s.charAt(j)) {
                System.out.println(false);
                return false;
            }
            i++;
            j--;
        }
        System.out.println(true);
        return true;
    }
}