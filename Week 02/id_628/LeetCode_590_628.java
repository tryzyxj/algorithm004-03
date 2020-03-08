//����һ�� N ������������ڵ�ֵ�ĺ�������� 
//
// ���磬����һ�� 3���� : 
//
// 
//
// 
//
// 
//
// ������������: [5,6,3,2,4,1]. 
//
// 
//
// ˵��: �ݹ鷨�ܼ򵥣������ʹ�õ�������ɴ�����? Related Topics ��


import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class LeetCode_590_628 {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        dfs(res,root);
        return res;
    }

    public void dfs(List<Integer> reslist , Node root){
        if(root == null) return ;
        if(root.children != null && root.children.size() != 0){
            for (Node node:root.children) {
                dfs(reslist , node);
            }
        }
        reslist.add(root.val);
        return ;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
