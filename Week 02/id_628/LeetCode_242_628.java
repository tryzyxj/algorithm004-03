//���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ� 
//
// ʾ�� 1: 
//
// ����: s = "anagram", t = "nagaram"
//���: true
// 
//
// ʾ�� 2: 
//
// ����: s = "rat", t = "car"
//���: false 
//
// ˵��: 
//����Լ����ַ���ֻ����Сд��ĸ�� 
//
// ����: 
//��������ַ������� unicode �ַ���ô�죿���ܷ������Ľⷨ��Ӧ����������� 
// Related Topics ���� ��ϣ��



//leetcode submit region begin(Prohibit modification and deletion)
class LeetCode_242_628 {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26] ;
        if(s.length() != t.length())return false;
        for (int i = 0 ; i < s.length() ; i++ ){
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int j = 0 ; j < arr.length ; j++){
            if(arr[j] != 0)return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
