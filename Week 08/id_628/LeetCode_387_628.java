//����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1�� 
//
// ����: 
//
// 
//s = "leetcode"
//���� 0.
//
//s = "loveleetcode",
//���� 2.
// 
//
// 
//
// ע����������Լٶ����ַ���ֻ����Сд��ĸ�� 
// Related Topics ��ϣ�� �ַ���



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> count = new HashMap<Character, Integer>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < n; i++) {
            if (count.get(s.charAt(i)) == 1)
                return i;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
