//������ N ��ѧ����������Щ�������ѣ���Щ���ǡ����ǵ���������Ǵ����ԡ������֪ A �� B �����ѣ�B �� C �����ѣ���ô���ǿ�����Ϊ A Ҳ�� C �����ѡ���ν������Ȧ����ָ�������ѵļ��ϡ� 
//
// ����һ�� N * N �ľ��� M����ʾ�༶��ѧ��֮������ѹ�ϵ�����M[i][j] = 1����ʾ��֪�� i ���� j ��ѧ����Ϊ���ѹ�ϵ������Ϊ��֪����������������ѧ���е���֪������Ȧ������ 
//
// ʾ�� 1: 
//
// 
//����: 
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//���: 2 
//˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�������һ������Ȧ��
//��2��ѧ���Լ���һ������Ȧ�����Է���2��
// 
//
// ʾ�� 2: 
//
// 
//����: 
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//���: 1
//˵������֪ѧ��0��ѧ��1��Ϊ���ѣ�ѧ��1��ѧ��2��Ϊ���ѣ�����ѧ��0��ѧ��2Ҳ�����ѣ���������������һ������Ȧ������1��
// 
//
// ע�⣺ 
//
// 
// N ��[1,200]�ķ�Χ�ڡ� 
// ��������ѧ������M[i][i] = 1�� 
// �����M[i][j] = 1������M[j][i] = 1�� 
// 
// Related Topics ����������� ���鼯



//leetcode submit region begin(Prohibit modification and deletion)
class UnionFind {
    private int count = 0;
    private int[] parent;
    public UnionFind(int n) {
        count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int p) {
        while (p != parent[p]) {
            parent[p] = parent[parent[p]];
            p = parent[p];
        }
        return p;
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) return;
        parent[rootP] = rootQ;
        count--;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public int[] getParent() {
        return parent;
    }
    public void setParent(int[] parent) {
        this.parent = parent;
    }
}
class LeetCode_547_628 {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        UnionFind uf = new UnionFind(len);
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (M[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.getCount();
    }
}


//leetcode submit region end(Prohibit modification and deletion)
