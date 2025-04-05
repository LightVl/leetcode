class Solution {
    public String simplifyPath(String path) {
        //String oneSlashPath = path.replaceAll("/+","/");
        Stack<String> stack = new Stack<>();
        //System.out.println(oneSlashPath);
        String[] splitted = path.split("/",0);
        System.out.println(Arrays.toString(splitted));
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