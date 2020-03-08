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
    public List<Integer> postorder(Node root) {
        Stack<Node> s = new Stack<>();
        List<Integer> result = new LinkedList<>();
        Node top;
        int i,len;
        if(root==null)return result;
        s.push(root);
        while(!s.isEmpty()){
            top = s.pop();
            len = top.children.size();
            result.add(0,top.val);
            for(i=0;i<len;i++){
                s.push(top.children.get(i));
            }
        }
        return result;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
