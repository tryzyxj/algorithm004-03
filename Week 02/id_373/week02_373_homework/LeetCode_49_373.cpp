#include <vector>
#include <algorithm>
#include <iostream>
#include <map>
#include <list>
#include <sstream>
using namespace std;

//49. ����һ���ַ������飬����ĸ��λ�������һ����ĸ��λ��ָ��ĸ��ͬ�������в�ͬ���ַ�����

//������Ľ���ؼ��ǣ�ĳһ���ַ����е�ĳһ����ĸ���ֵ�Ƶ���������ַ����Ķ�Ӧ��ĸ�ĳ���Ƶ����ͬ��
//������λ�ò�ͬ���ˣ��������ǵķ����ǿ��Ժ���λ�ã���������ÿ���ַ����ֵ�Ƶ����

/*
����˼·һ��ʹ��map��sort����
ʱ�临�Ӷȣ�O(Knlogn) K�����ַ�������
������ʹ��map��ÿһ��sort���string����key���������飬�����һ���ַ�����sort��Ľ����map��key���Ѿ����ڣ�
	 ����뵽list��ȥ����������ڵĻ���������һ���µ�key��
*/
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs) 
{
	map<string, vector<string>> strMap;
	vector<vector<string>> resultVec;

	if (0 == strs.size())
		return resultVec;
	//vector<string> strSrc = strs; //����sort�����ķ���ֵ��void������copy��һ��src vector���Ľ�����ʹ����ʱ�����Ͳ���copyһ�ݡ�
	for (int i = 0; i < strs.size(); i++)
	{
		string temp = strs[i];
		sort(strs[i].begin(), strs[i].end());

		if(strMap.find(strs[i]) == strMap.end())
		{
			strMap[strs[i]] = vector<string>();
		} 

		strMap[strs[i]].push_back(temp);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	/*map<string, vector<string>>::iterator strMap_iter = strMap.begin();
	for (; strMap_iter != strMap.end(); strMap_iter++)
	{
		resultVec.push_back(strMap_iter->second);
	}*/

	return resultVec;
}
#endif

//���������滻�汾
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs) {

	map<string, vector<string>> strMap;
	vector<vector<string>> resultVec;

	if (0 == strs.size())
		return resultVec;

	for (int i = 0; i < strs.size(); i++)
	{
		string temp = strs[i];
		sort(strs[i].begin(), strs[i].end());

		strMap[strs[i]].push_back(temp);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	return resultVec;

}
#endif

//leetcode �ϲο�
#if 0
vector<vector<string>> groupAnagrams(vector<string>& strs)
{
	map<string, vector<string> > ma;
	vector<vector<string>> res;
	for (auto str : strs)
	{
		string tmp = str;
		sort(tmp.begin(), tmp.end());
		ma[tmp].push_back(str);
	}
	for (const auto& m : ma)
		res.push_back(m.second);
	return res;
}
#endif

/*
����˼·����ʹ��map����
ʱ�临�Ӷȣ�O(Kn) K�����ַ�������
������ͳ��ÿ���ַ���ÿ���ַ����г��ֵ�Ƶ�����26����ĸ������count��Ȼ���countת����string��Ϊmap�Ŀ��ԣ�Ȼ�����vector��
	 ��һ���ַ�����count string������map���е�key�У��Ͱ����ӵ�����������������µ�key��
*/
#if 1
vector<vector<string>> groupAnagrams(vector<string>& strs)
{
	vector<vector<string>> resultVec;
	map<string, vector<string>> strMap;
	if (0 == strs.size())
		return resultVec;
	
	for (string item : strs)
	{
		stringstream s;
		int count[26] = { 0 };
		for (int i = 0; i < item.length(); i++)
		{
			count[item.at(i) - 'a'] ++;
		}

		for (int i = 0; i < 26; i++)
		{
			s << count[i];
		}

		/*
		if (strMap.find(s.str()) == strMap.end())
			strMap[s.str()] = vector<string>();
		*/

		strMap[s.str()].push_back(item);
	}

	for (pair<string, vector<string>> item : strMap)
		resultVec.push_back(item.second);

	/*
	map<string, vector<string>>::iterator map_iter = strMap.begin();
	for (; map_iter != strMap.end(); map_iter++)
	{
		resultVec.push_back(map_iter->second);
	}
	*/

	return resultVec;
}
#endif

/*
int main()
{

	string strs[6] = {"are","bat", "ear", "code", "tab", "era"};
	vector<string> strV;
	cout << strs->size() << endl;
	for (int i = 0; i < 6; i++)
	{
		strV.push_back(strs[i]);
	}
	cout << strV.size() << endl;

	vector<vector<string>> result = groupAnagrams(strV);

	while (1);
	return 0;
}
*/