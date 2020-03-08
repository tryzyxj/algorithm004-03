//����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ����� 
//
// ʾ��: 
//
// ����: ["eat", "tea", "tan", "ate", "nat", "bat"],
//���:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// ˵���� 
//
// 
// ���������ΪСд��ĸ�� 
// �����Ǵ������˳�� 
// 
// Related Topics ��ϣ�� �ַ���



//leetcode submit region begin(Prohibit modification and deletion)
//����˳������ÿ�����ʣ��͵���ⷨ���ơ�
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hash = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] s_arr = strs[i].toCharArray();
            Arrays.sort(s_arr);
            String key = String.valueOf(s_arr);
            if (hash.containsKey(key)) {
                hash.get(key).add(strs[i]);
            } else {
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hash.put(key, temp);
            }

        }
        return new ArrayList<List<String>>(hash.values());
    }
}
//leetcode submit region end(Prohibit modification and deletion)
