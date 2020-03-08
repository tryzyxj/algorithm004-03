//����һ������������������ ǰ�� ������ 
//
// ʾ��: 
//
// ����: [1,null,2,3]  
//   1
//    \
//     2
//    /
//   3 
//
//���: [1,2,3]
// 
//
// ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨����� 
// Related Topics ջ ��



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            output.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }
        return output;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
