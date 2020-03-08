//���谴�����������������Ԥ��δ֪��ĳ�����Ͻ�������ת�� 
//
// ( ���磬���� [0,1,2,4,5,6,7] ���ܱ�Ϊ [4,5,6,7,0,1,2] )�� 
//
// ���ҳ�������С��Ԫ�ء� 
//
// ����Լ��������в������ظ�Ԫ�ء� 
//
// ʾ�� 1: 
//
// ����: [3,4,5,1,2]
//���: 1 
//
// ʾ�� 2: 
//
// ����: [4,5,6,7,0,1,2]
//���: 0 
// Related Topics ���� ���ֲ���



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_153_628 {
    public int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] < nums[right])
                right = mid;
            else
                left = mid + 1;
        }
        return nums[left];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
