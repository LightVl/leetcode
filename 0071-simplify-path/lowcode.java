import java.util.Arrays;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String path = "/...////a/../b/c/../////////d/./";
        String oneSlashPath = path.replaceAll("/+","/");
        Stack<String> stack = new Stack<>();
        System.out.println(oneSlashPath);
        String[] splitted = oneSlashPath.split("/",0);
        System.out.println(Arrays.toString(splitted));
        StringBuilder result = new StringBuilder();
        for (String c : splitted) {
            switch (c) {
                case "":
                case ".": break;
                case"..":
                    stack.pop();
                    break;
                default:
                    stack.push(c);
            }
        }

        String[] arr = stack.toArray(new String[stack.size()]);
        for (String a:arr) {
            result.append("/");
            result.append(a);
        }
        System.out.println(result.toString());
    }
}
