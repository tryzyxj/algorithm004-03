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

import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LeetCode_144_628 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    public void dfs(List<Integer> reslist , TreeNode root){
        if(root == null) return ;
        reslist.add(root.val);
        if(root.left != null) dfs(reslist,root.left);
        if (root.right != null) dfs(reslist , root.right);
        return ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
