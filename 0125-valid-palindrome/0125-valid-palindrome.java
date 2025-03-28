class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char a:s.toCharArray()) {
            if(Character.isLetterOrDigit(a)) {
                sb.append(Character.toLowerCase(a));
            }
        }
        s= sb.toString();
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