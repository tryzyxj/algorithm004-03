//����һ���������������������� ������ 
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
//���: [1,3,2] 
//
// ����: �ݹ��㷨�ܼ򵥣������ͨ�������㷨����� 
// Related Topics ջ �� ��ϣ��



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
class LeetCode_94_628 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    public void dfs( List<Integer> reslist , TreeNode root){
        if(root == null) return ;
        if(root.left != null) dfs(reslist,root.left);
        reslist.add(root.val);
        if (root.right != null) dfs(reslist , root.right);
        return ;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
