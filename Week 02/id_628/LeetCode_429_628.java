//����һ�� N ������������ڵ�ֵ�Ĳ�������� (�������ң�������)�� 
//
// ���磬����һ�� 3���� : 
//
// 
//
// 
//
// 
//
// ������������: 
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
// 
//
// 
//
// ˵��: 
//
// 
// ������Ȳ��ᳬ�� 1000�� 
// ���Ľڵ��������ᳬ�� 5000�� 
// Related Topics �� �����������


import java.util.LinkedList;

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
class LeetCode_429_628 {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null )return new ArrayList<List<Integer>>();
        List<List<Integer>>  list = new ArrayList<List<Integer>>();
        List<Node> curLevellist = new ArrayList<Node>();
        curLevellist.add(root);
        dfs(curLevellist,list);
        return list;
    }


    public void dfs(List<Node> curLevellist , List<List<Integer>> reslist){
        if(curLevellist == null || curLevellist.size() == 0)return ;
        List<Node> nextList = new LinkedList<Node>();
        List<Integer> vallist = new LinkedList<Integer>();
        for (Node node: curLevellist) {
            vallist.add(node.val);
            if(node.children != null){
                for(Node nnode : node.children){
                    nextList.add(nnode);
                }
            }
        }
        reslist.add(vallist);
        dfs(nextList,reslist);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
