class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] splitted = path.split("/",0);
        StringBuilder result = new StringBuilder();
        for (String c : splitted) {
            switch (c) {
                case "":
                case ".": break;
                case"..":
                    if(stack.empty()) {
                    break;
                } else
                    stack.pop();
                    break;
                default:
                    stack.push(c);
            }
        }
        if(stack.empty()) return "/";
        String[] arr = stack.toArray(new String[stack.size()]);
        for (String a:arr) {
            result.append("/");
            result.append(a);
        }
        System.out.println(result.toString());
        return result.toString();  
    }
}