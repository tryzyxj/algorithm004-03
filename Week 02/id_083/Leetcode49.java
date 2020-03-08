/*
49��ĸ��λ�ʷ���

����һ���ַ������飬����ĸ��λ�������һ��
��ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����


ʾ��:


����: ["eat", "tea", "tan", "ate", "nat", "bat"],

���:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

˵����


���������ΪСд��ĸ��

�����Ǵ������˳��
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }
}
