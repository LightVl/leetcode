class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        Map<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        if(digits.length()==0) {
            return result;
        }
        result.add("");
        for (char digit: digits.toCharArray() ) {
            List<String> temp = new ArrayList<>();
            for (String combination : result) {
                for (char addition : map.get(digit).toCharArray()) {
                    temp.add(combination + addition);
                }
            }
            result = temp;
        }
        System.out.println(result);
        return result;
    }
}