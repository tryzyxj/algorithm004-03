//���������ַ��� s �� t���ж������Ƿ���ͬ���ġ� 
//
// ��� s �е��ַ����Ա��滻�õ� t ����ô�������ַ�����ͬ���ġ� 
//
// ���г��ֵ��ַ�����������һ���ַ��滻��ͬʱ�����ַ���˳�������ַ�����ӳ�䵽ͬһ���ַ��ϣ����ַ�����ӳ���Լ����� 
//
// ʾ�� 1: 
//
// ����: s = "egg", t = "add"
//���: true
// 
//
// ʾ�� 2: 
//
// ����: s = "foo", t = "bar"
//���: false 
//
// ʾ�� 3: 
//
// ����: s = "paper", t = "title"
//���: true 
//
// ˵��: 
//����Լ��� s �� t ������ͬ�ĳ��ȡ� 
// Related Topics ��ϣ��



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isIsomorphic(String s, String t) {
       char[] arr1 =  s.toCharArray();
       char[] arr2 =  t.toCharArray();
       for (int i = 0; i <s.length() ; i++) {
            if (s.indexOf(arr1[i]) != t.indexOf(arr2[i]))return false;

       }
       return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
