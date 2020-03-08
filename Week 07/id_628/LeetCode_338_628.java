//����һ���Ǹ����� num������ 0 �� i �� num ��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء� 
//
// ʾ�� 1: 
//
// ����: 2
//���: [0,1,1] 
//
// ʾ�� 2: 
//
// ����: 5
//���: [0,1,1,2,1,2] 
//
// ����: 
//
// 
// ����ʱ�临�Ӷ�ΪO(n*sizeof(integer))�Ľ��ǳ����ס��������������ʱ��O(n)����һ��ɨ�������� 
// Ҫ���㷨�Ŀռ临�Ӷ�ΪO(n)�� 
// ���ܽ�һ�����ƽⷨ��Ҫ����C++���κ����������в�ʹ���κ����ú������� C++ �е� __builtin_popcount����ִ�д˲����� 
// 
// Related Topics λ���� ��̬�滮



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_338_628 {
    public int[] countBits(int num) {
        int[] arr = new int[num+1];
        for (int i = 0; i <= num ; i++) {
            arr[i] = hammingWeight(i);
        }
        return arr;
    }

    public int hammingWeight(int n) {
        if(n == 0)return 0;
        int count = 0 ;
        while(n != 0){
            n = n & (n-1);
            count ++ ;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
