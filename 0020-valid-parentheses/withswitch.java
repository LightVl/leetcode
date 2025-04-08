import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s="]";
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
                        return;
                    }
                    else if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                    break;
                case ']':
                    if(stack.empty()) {
                        System.out.println(false);
                        return;
                    }
                    else if (stack.peek() == '[') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                    break;
                case '}':
                    if(stack.empty()) {
                        System.out.println(false);
                        return;
                    }
                    else if (stack.peek() == '{') {
                        stack.pop();
                    } else {
                        System.out.println(false);
                        return;
                    }
                    break;
                default:
                    System.out.println(false);
                    return;
            }
        }
        if (stack.empty()) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
