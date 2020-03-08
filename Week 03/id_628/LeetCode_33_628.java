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
class LeetCode_33_628 {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + ((right - left) >> 1);

            if (nums[mid] < nums[right]) {
                //��ת��������
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        //��ת������Ϊleft
        int changePoint = left;
        left = 0;
        right = nums.length - 1;

        while (left <= right) {
            //�����е�
            int mid = left + ((right - left) >> 1);
            //����е㣬��ƫ����֮��ȡ����ģ
            int realmid=(mid+changePoint) % nums.length;
            //
            if(nums[realmid]==target)return realmid;
            if(nums[realmid]<target)left=mid+1;
            else right=mid-1;
        }

        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
