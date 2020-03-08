import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        //�����ֵ���
        WordTrie myTrie=new WordTrie();
        TrieNode root=myTrie.root;
        for(String s:words)
            myTrie.insert(s);

        //ʹ��set��ֹ�ظ�
        Set<String> result =new HashSet<>();
        int m=board.length;
        int n=board[0].length;
        boolean [][]visited=new boolean[m][n];
        //����������ά����
        for(int i=0;i<board.length; i++){
            for (int j = 0; j < board [0].length; j++){
                find(board,visited,i,j,m,n,result,root);
            }
        }
        System.out.print(result);
        return new LinkedList<String>(result);
    }
    private void find(char [] [] board, boolean [][]visited,int i,int j,int m,int n,Set<String> result, TrieNode cur){
        //�߽��Լ��Ƿ��Ѿ������ж�
        if(i<0||i>=m||j<0||j>=n||visited[i][j])
            return;
        cur=cur.child[board[i][j]-'a'];
        visited[i][j]=true;
        if(cur==null) {
            //������ʲ�ƥ�䣬����
            visited[i][j]=false;
            return;
        }
        //�ҵ����ʼ���
        if(cur.isLeaf)
        {
            result.add(cur.val);
            //�ҵ����ʺ��ܻ��ˣ���Ϊ�����ǡ�ad�� ��addd�������ĵ��ʵü�������
//            visited[i][j]=false;
//            return;
        }
        find(board,visited,i+1,j,m,n,result,cur);
        find(board,visited,i,j+1,m,n,result,cur);
        find(board,visited,i,j-1,m,n,result,cur);
        find(board,visited,i-1,j,m,n,result,cur);
        //���Ҫ���ˣ���Ϊ��һ�������ܻ��õ���һ�������ַ�
        visited[i][j]=false;
    }
}
class WordTrie{
    public TrieNode root=new TrieNode();
    public void insert(String s){
        TrieNode cur=root;
        for(char c:s.toCharArray()){
            if(cur.child[c-'a']==null){
                cur.child [c-'a'] = new TrieNode();
                cur=cur.child[c-'a'];
            }else
                cur=cur.child [c-'a'];
        }
        cur.isLeaf=true;
        cur.val=s;
    }
}
//�ֵ������
class TrieNode{
    public String val;
    public TrieNode[] child=new TrieNode[26];
    public boolean isLeaf=false;

    TrieNode(){

    }
}