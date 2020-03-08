#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

//1. ����֮��
/*
����˼·һ���������
ʱ�临�Ӷȣ�O(n^2)
�������������飬���������ҵ�target-nums[i]��ֵ
*/
#if 0
vector<int> twoSum(vector<int>& nums, int target)
{
	vector<int> result;
	for (int i = 0; i < nums.size(); i++)
	{
		for (int j = i + 1; j < nums.size(); j++)
		{
			if (nums[i] == target - nums[j])
			{
				result.push_back(i);
				result.push_back(j);
			}
		}
	}

	return result;
}
#endif

/*
����˼·�������߱���map�ⷨ�� �������е�Ԫ�ش�Ϊmap��key��������c++�е�map����hash map�����Դ���һ��������ǣ��������е�Ԫ�ش����ظ���ʱ��ʹ��ˡ�
ʱ�临�Ӷȣ�O(n)
�������������飬��map�����Ƿ��д��ڵ�key��
*/
#if 0
vector<int> twoSum(vector<int>& nums, int target)
{
	vector<int> result;
	map<int, int> tempMap;
	for (int i = 0; i < nums.size(); i++)
	{
		tempMap[nums[i]] = i;
	}

	for (int i = 0; i < nums.size(); i++)
	{
		if (tempMap.find(target - nums[i]) != tempMap.end() && tempMap[target - nums[i]] != i)
		{
			result.push_back(tempMap[target - nums[i]]);
		}
	}

	return result;
}
#endif

/*
����˼·����һ��map �������е�Ԫ�ش�Ϊmap��key��
ʱ�临�Ӷȣ�O(n)
�������������飬��map�����Ƿ��д��ڵ�key��
*/
vector<int> twoSum(vector<int>& nums, int target)
{
	unordered_map <int, int> m;
	vector <int> ret;

	for (int i = 0; i < nums.size(); i++)
	{
		if (m.find(target - nums[i]) != m.end())
		{
			ret.push_back(m[target - nums[i]]);
			ret.push_back(i);
			break;
		}
		m[nums[i]] = i;
	}
	return ret;
}

/*
int main()
{
	int value[4] = {2, 7, 2, 15};

	vector<int> nums;
	for (int i = 0; i < 4; i++)
		nums.push_back(value[i]);

	vector<int> result = twoSum(nums, 9);
	for (int item : result)
	{
		cout << item << endl;
	}

	while (1);

	return 0;
}
*/