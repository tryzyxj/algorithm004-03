/*
242��Ч����ĸ��λ��
���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ����ĸ��λ�ʡ�


ʾ��?
1:

����: s = "anagram", t = "nagaram"

���: true
ʾ�� 
2:

����: s = "rat", t = "car"

���: false


*/


class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i =0;i<s.length();i++) {
        	if(map.containsKey(s.charAt(i)))
        		map.put(s.charAt(i), map.get(s.charAt(i))+1);
        	else 
        		map.put(s.charAt(i), 1); 
        }
        for(int j=0;j<t.length();j++) {
        	if(map.containsKey(t.charAt(j))) {
        		map.put(t.charAt(j), map.get(t.charAt(j))-1);
        		if(map.get(t.charAt(j))==0) 
        			map.remove(t.charAt(j), map.get(t.charAt(j)));
            }else
                return false;
        }
        return map.isEmpty();
    }
}