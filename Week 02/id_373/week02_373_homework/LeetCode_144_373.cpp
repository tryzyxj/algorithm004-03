#include <iostream>
#include <vector>
#include <stack>
using namespace std;

//144. ��������ǰ�����
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	
	TreeNode(int x) : val(x), left(NULL), right(NULL) { }
};


//vector<int> result;
/*
����˼·һ���ݹ�
ʱ�临�Ӷȣ�O(n)
�������ȸ��ڵ�����̽����һ�������������Ȼ����������......
*/
#if 0
vector<int> preorderTraversal(TreeNode *root) {
	if (root != NULL) {
		result.push_back(root->val);
		preorderTraversal(root->left);
		preorderTraversal(root->right);
	}

	return result;
}
#endif

/*
����˼·����ʹ��stack
ʱ�临�Ӷȣ�O(n)
�������Ӹ��ڵ㿪ʼֱ�ӱ�����ڵ�����ӣ��Һ��ӷŵ�ջ��......
*/
#if 0
vector<int> preorderTraversal(TreeNode *root) {
	vector<int> result;
	stack<TreeNode *> treeNodeStack;
	TreeNode *cur = root;
	while (cur != NULL || !treeNodeStack.empty()) {
		while (cur != NULL) {
			if (cur->right != NULL) {
				treeNodeStack.push(cur->right);
			}
			result.push_back(cur->val);
			cur = cur->left;
		}

		if (!treeNodeStack.empty()) {   //��������cur->right is empty����treeNodeStackΪ�գ�Ȼ��pop�ͳ��ֶδ���
			cur = treeNodeStack.top();
			treeNodeStack.pop();
		}
	}
	return result;
}
#endif

/*
����˼·����ʹ��stack
ʱ�临�Ӷȣ�O(n)
�������ȸ��ڵ㿪ʼ���浽ջ�У�Ȼ���Ȱ��Һ��ӱ��浽ջ�У��ڱ������ӣ�Ȼ�󵯳�top��Ҳ�������ӣ��ظ�����......
*/
vector<int> preorderTraversal(TreeNode *root) {
	vector<int> result;
	if (root == NULL)
		return result;

	stack<TreeNode *> treeNodeStack;

	TreeNode * cur = root;
	treeNodeStack.push(cur);
	while (!treeNodeStack.empty()) {
		cur = treeNodeStack.top();
		result.push_back(cur->val);

		treeNodeStack.pop();

		if (cur->right != NULL) {
			treeNodeStack.push(cur->right);
		}

		if (cur->left != NULL) {
			treeNodeStack.push(cur->left);
		}
	}

	return result;
}

//�������ĵݹ鷽ʽ����

int main()
{
	TreeNode node3(3);
	TreeNode node2(2);
	node2.left = &node3;
	TreeNode node1(1);
	node1.right = &node2;

	vector<int> result = preorderTraversal(&node1);

	for (int item : result)
	{
		cout << item << endl;
	}


	while (1);
	return 0;
}