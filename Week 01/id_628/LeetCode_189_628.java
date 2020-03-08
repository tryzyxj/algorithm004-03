//����һ�����飬�������е�Ԫ�������ƶ� k ��λ�ã����� k �ǷǸ����� 
//
// ʾ�� 1: 
//
// ����: [1,2,3,4,5,6,7] �� k = 3
//���: [5,6,7,1,2,3,4]
//����:
//������ת 1 ��: [7,1,2,3,4,5,6]
//������ת 2 ��: [6,7,1,2,3,4,5]
//������ת 3 ��: [5,6,7,1,2,3,4]
// 
//
// ʾ�� 2: 
//
// ����: [-1,-100,3,99] �� k = 2
//���: [3,99,-1,-100]
//����: 
//������ת 1 ��: [99,-1,-100,3]
//������ת 2 ��: [3,99,-1,-100] 
//
// ˵��: 
//
// 
// �������������Ľ�����������������ֲ�ͬ�ķ������Խ��������⡣ 
// Ҫ��ʹ�ÿռ临�Ӷ�Ϊ O(1) �� ԭ�� �㷨�� 
// 
// Related Topics ����



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_189_628 {
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length == 0)return;
        int m = k % nums.length;
        reverse(nums , 0 , nums.length-1 );
        reverse(nums , 0 , m-1 );
        reverse(nums , m , nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end){
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++ ;
            end --;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/*
    1��������
    ˫��ѭ����һλһλŲ�ƣ���һ���滻λʵ��
    2����������
    ��������������չ�󣬶�k�ĵ�һ��ͬ�಻�����ظ��������Ų�ƣ���Ҫһ������
    3����ת����
    �������鷴ת���ٷ�תǰk����0~k-1������k��ĩβ��k~len-1��������ʵ��
 */
