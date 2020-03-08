//һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ���� 
//
// ������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������ 
//
// ���ܹ��ж�������ͬ��·���� 
//
// 
//
// ���磬��ͼ��һ��7 x 3 �������ж��ٿ��ܵ�·���� 
//
// ˵����m �� n ��ֵ�������� 100�� 
//
// ʾ�� 1: 
//
// ����: m = 3, n = 2
//���: 3
//����:
//�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
//1. ���� -> ���� -> ����
//2. ���� -> ���� -> ����
//3. ���� -> ���� -> ����
// 
//
// ʾ�� 2: 
//
// ����: m = 7, n = 3
//���: 28 
// Related Topics ���� ��̬�滮



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_62_628 {
    //�߽�����
    //����dp����
    //��ʼ��dp����
    //״̬ת�Ʒ���
    public int uniquePaths(int m, int n) {
        //�߽�����
        if(m == 0 || n == 0)return -1;
        //����dp����
        int[][] dp =  new int[m][n];
        //��ʼ��dp����
        dp[m-1][n-1] = 1;
        for (int i = m-2; i >= 0 ; i--) {
            dp[i][n-1] = 1;
        }
        for (int i = n-2; i >= 0 ; i--) {
            dp[m-1][i] = 1;
        }
        //״̬ת�Ʒ���
        for (int i = m-2; i >= 0  ; i--) {
            for (int j = n-2; j >= 0  ; j--) {
                dp[i][j] = dp[i+1][j] + dp[i][j+1];
            }
        }
        return dp[0][0];

    }
}
//leetcode submit region end(Prohibit modification and deletion)
