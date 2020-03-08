//��дһ����Ч���㷨���ж� m x n �����У��Ƿ����һ��Ŀ��ֵ���þ�������������ԣ� 
//
// 
// ÿ���е����������Ұ��������С� 
// ÿ�еĵ�һ����������ǰһ�е����һ�������� 
// 
//
// ʾ�� 1: 
//
// ����:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 3
//���: true
// 
//
// ʾ�� 2: 
//
// ����:
//matrix = [
//  [1,   3,  5,  7],
//  [10, 11, 16, 20],
//  [23, 30, 34, 50]
//]
//target = 13
//���: false 
// Related Topics ���� ���ֲ���



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0)
        return false;
        int row = 0, col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col])
                return true;
            else if (target > matrix[row][col])
                row++;
            else
                col--;
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
