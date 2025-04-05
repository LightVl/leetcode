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
                    if(stack.empty()) {
                        System.out.println(false);
                        return false;
                    }
                    else if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return false;
                    }
                    break;
                case ']':
                    if(stack.empty()) {
                        System.out.println(false);
                        return false;
                    }
                    else if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return false;
                    }
                    break;
                case '}':
                    if(stack.empty()) {
                        System.out.println(false);
                        return false;
                    }
                    else if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return false;
                    }
                    break;
                default:
                    System.out.println(false);
                    return false;
            }
        }
        if (stack.empty()) {
            System.out.println(true);
            return true;
        } else {
            return false;
        }    
    }
}