public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(4);
        TreeNode root4 = new TreeNode(5);
        root.left = root1;
        root.right = root2;
        root.left.right = root3;
        root.left.right.right = root4;
        if (root == null)
            return;
        TreeNode dummyHead = new TreeNode();
        TreeNode result = shrink(root,dummyHead);
        root = dummyHead.right;
        System.out.println(root.val);
        System.out.println(root.right.val);
        System.out.println(root.right.right.val);
        System.out.println(root.right.right.right.val);
        System.out.println(root.right.right.right.right.val);
    }
    public static TreeNode shrink(TreeNode root, TreeNode result) {
        if (root == null)
            return result;
        TreeNode temp = new TreeNode(root.val);
        result.right = temp;
        result = result.right;
        result = shrink(root.left,result);
        result = shrink(root.right,result);
        return result;
    }
