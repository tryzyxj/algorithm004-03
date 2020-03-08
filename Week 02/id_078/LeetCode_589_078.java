//����һ�� N ������������ڵ�ֵ��ǰ������� 
//
// ���磬����һ�� 3���� : 
//
// 
//
// 
//
// 
//
// ������ǰ�����: [1,3,5,6,2,4]�� 
//
// 
//
// ˵��: �ݹ鷨�ܼ򵥣������ʹ�õ�������ɴ�����? Related Topics ��



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
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null){
            return list;
        }
        list.add(root.val);
        for(Node n : root.children){
            preorder(n);
        }
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
