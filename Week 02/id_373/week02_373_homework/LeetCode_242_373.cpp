#include <iostream>
#include <stdio.h>
#include <vector>
#include <string>
#include <algorithm>
#include <map>
using namespace std;

//242. ��Ч����ĸ��λ��
/*
��ȷ�����еĵ㣺
��1����Сд�Ƿ�����
*/

/*
�����˼·��
��1����ʼ����Ϊ�������ַ�����asciiֵ�Աȣ��������ֲ��ԣ��磺ac, bb
bool isAnagram(string s, string t)
{
	if (s.length() != t.length())
		return false;

	int sCount = 0;
	int tCount = 0;
	for (int i = 0; i < s.length(); i++)
	{
		sCount += s.at(i);
		tCount += t.at(i);
	}
	if (sCount == tCount)
		return true;
	else
		return false;
}
*/

/*
����˼·һ������ö��
ʱ�临�Ӷȣ�O(n^2)
��������һ���ñ���ö�ٵ�ʱ��û���뵽����ڶ����ַ������ظ����ֵ�һ���ַ����е�ĳ���ַ��������Ȼ������磺"aacc", "ccac"��
*/
#if 0
bool isAnagram(string s, string t)
{
	if (s.length() != t.length())
		return false;

	for (int i = 0; i < s.length(); i++)
	{
		for (int j = 0; j < t.length(); j++)
		{
			if (s.at(i) == t.at(j))
			{
				t.replace(j, 1, "");
				break;
			}
			else
			{
				if (j == t.length() - 1)
					return false;

				continue;
			}
		}
	}

	return true;
}
#endif

/*
����˼·��������ö��
ʱ�临�Ӷȣ�O(nlogn)
�������������ַ���sortһ�飬Ȼ��Ƚ�sort��Ľ����
*/
#if 0
bool isAnagram(string s, string t)
{
	sort(s.begin(), s.end());
	sort(t.begin(), t.end());

	cout << s << endl;;
	cout << s.size() << endl;
	cout << t << endl;
	cout << t.size() << endl;

	if (!s.compare(t)) return true;
	
	return false;
}
#endif

/*
����˼·����hashӳ��
ʱ�临�Ӷȣ�O(n)
��������s�г��ֵ��ַ�һ����t�г��֣��Ƚ�ÿ���ַ��ڸ����ַ����г��ֵĴ���
	 newһ��26��intԪ�ص����飬ÿ������Ԫ�ؼ�¼��Ӧ�ַ����ֵĴ�������
     ������������������������һ������Ԫ�صĲΪ�㣬�Ͳ���anagram�ַ�����
*/
#if 0
bool isAnagram(string s, string t)
{
	if (s.length() != t.length()) {
		return false;
	}
	int counter[26] = {0};
	for (int i = 0; i < s.length(); i++) {
		counter[s.at(i) - 'a']++;
		counter[t.at(i) - 'a']--;
	}
	for (int count : counter) {
		if (count != 0) {
			return false;
		}
	}
	return true;
}
#endif

bool isAnagram(string s, string t)
{
	if (s.length() != t.length()) 
		return false;

	int counter[26] = {0};
	for (int i = 0; i < s.length(); i++)
	{
		counter[s.at(i) - 'a']++;
	}
	for (int i = 0; i < t.length(); i++)
	{
		int count = counter[t.at(i) - 'a']--;
		if(count < 0)
			return false;
	}

	return true;
}


/*
int main()
{
	string s, t;
	s = "anagram";
	t = "nagaram";
	//isAnagram(s, t);

	if (isAnagram(s, t))
		printf("yes");
	else
		printf("no");

	while (1);

	return 0;
}
*/

