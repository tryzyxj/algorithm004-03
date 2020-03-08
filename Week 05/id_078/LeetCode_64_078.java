//����һ�������Ǹ������� m x n �������ҳ�һ�������Ͻǵ����½ǵ�·����ʹ��·���ϵ������ܺ�Ϊ��С�� 
//
// ˵����ÿ��ֻ�����»��������ƶ�һ���� 
//
// ʾ��: 
//
// ����:
//[
//? [1,3,1],
//  [1,5,1],
//  [4,2,1]
//]
//���: 7
//����: ��Ϊ·�� 1��3��1��1��1 ���ܺ���С��
// 
// Related Topics ���� ��̬�滮



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {
                if(i == grid.length - 1 && j != grid[0].length - 1)
                    dp[j] = grid[i][j] +  dp[j + 1];
                else if(j == grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + dp[j];
                else if(j != grid[0].length - 1 && i != grid.length - 1)
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
                else
                    dp[j] = grid[i][j];
            }
        }
        return dp[0];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
