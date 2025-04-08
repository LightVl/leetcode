class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> dataList = new ArrayList<>(Arrays.asList('(', '[', '{', ')', ']', '}'));
        for (Character c : s.toCharArray()) {
            if (c == dataList.get(0) || c == dataList.get(1) || c == dataList.get(2)) {
                stack.push(c);
            }
            for (int i = 0; i < 3; i++) {
                if (c == dataList.get(3 + i)) {
                    if (!stack.isEmpty() && stack.peek() == dataList.get(i)) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}