class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        ArrayList<Character> dataList = new ArrayList<>(Arrays.asList('(', '[', '{', ')', ']', '}'));
        for (Character c : s.toCharArray()) {
            if (c == dataList.get(0) || c == dataList.get(1) || c == dataList.get(2)) {
                stack.push(c);
            }
            if (c == dataList.get(3)) {
                if (!stack.isEmpty() && stack.peek() == dataList.get(0)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (c == dataList.get(4)) {
                if (!stack.isEmpty() && stack.peek() == dataList.get(1)) {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if (c == dataList.get(5)) {
                if (!stack.isEmpty() && stack.peek() == dataList.get(2)) {
                    stack.pop();
                } else {
                    return false;
                }
            }

        }
        return stack.isEmpty();
    }
}