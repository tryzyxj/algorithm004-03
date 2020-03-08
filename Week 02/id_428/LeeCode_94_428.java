
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        // �ݹ�
        if (root != null) traversal(root, list);

        //ջ�ķ�ʽ
//        Stack<TreeNode> stack = new Stack<TreeNode>();
//        TreeNode cur = root;
//        while(cur!=null || !stack.empty()){
//            while(cur!=null){
//                stack.add(cur);
//                cur = cur.left;
//            }
//            cur = stack.pop();
//            list.add(cur.val);
//            cur = cur.right;
//        }
        return list;
    }
    private void traversal(TreeNode node, List<Integer> list) {
        if (node.left != null) traversal(node.left, list);
        list.add(node.val);
        if (node.right != null) traversal(node.right, list);
    }
	
}