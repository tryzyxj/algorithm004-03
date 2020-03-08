//����һ���������� nums ��һ��Ŀ��ֵ target�������ڸ��������ҳ���ΪĿ��ֵ���� ���� ���������������ǵ������±ꡣ 
//
// ����Լ���ÿ������ֻ���Ӧһ���𰸡����ǣ��㲻���ظ��������������ͬ����Ԫ�ء� 
//
// ʾ��: 
//
// ���� nums = [2, 7, 11, 15], target = 9
//
//��Ϊ nums[0] + nums[1] = 2 + 7 = 9
//���Է��� [0, 1]
// 
// Related Topics ���� ��ϣ��



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_1_628 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> cache=new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length; i++) {
            if(cache.containsKey(target-nums[i])){
                return new int[] {cache.get(target-nums[i]),i};
            }
            cache.put(nums[i], i);
        }
        return new int[] {};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
/****
 *  1.������
 *  2.˫ָ��
 *  3.��������
 */
