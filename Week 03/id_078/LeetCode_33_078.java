//���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת�� 
//
// ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )�� 
//
// ����һ��������Ŀ��ֵ����������д������Ŀ��ֵ���򷵻��������������򷵻� -1 �� 
//
// ����Լ��������в������ظ���Ԫ�ء� 
//
// ����㷨ʱ�临�Ӷȱ����� O(log n) ���� 
//
// ʾ�� 1: 
//
// ����: nums = [4,5,6,7,0,1,2], target = 0
//���: 4
// 
//
// ʾ�� 2: 
//
// ����: nums = [4,5,6,7,0,1,2], target = 3
//���: -1 
// Related Topics ���� ���ֲ���



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        int mid;
        while (start <= end) {

            mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[start] <= nums[mid]) {
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }

        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
