class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (!stack.isEmpty()&&stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty()&&stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if (!stack.isEmpty()&&stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                default:
                    System.out.println(false);
                    return false;
            }
        }
        return stack.isEmpty();  
    }
}