#include <iostream> 
#include <vector>
#include <stack>
using namespace std;

//94. ���������������
struct TreeNode {
	int val;
	TreeNode * left;
	TreeNode * right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
vector<int> result;

/*
����˼·һ���ݹ�
ʱ�临�Ӷȣ�O(n) 
��������������һ��һ�����̽����Ҷ�ӽڵ��ʱ�򷵻���һ��add��������root�ڵ㣬Ȼ����һ��һ�����̽������......
*/

#if 0
vector<int> inorderTraversal(TreeNode* root) {
	if (root != NULL) {
		inorderTraversal(root->left);
		result.push_back(root->val);
		inorderTraversal(root->right);
	}
	
	return result;
}
#endif

/*
����˼·����ʹ��ջ
ʱ�临�Ӷȣ�O(n)
������ÿһ����̽�����������������Ҷ�ӽڵ�ͰѸĽڵ㵯����Ȼ���ڲ���������.......
*/
vector<int> inorderTraversal(TreeNode* root) {
	vector<int> result;
	stack<TreeNode*> treeStack;
	TreeNode * cur = root;
	while (cur != NULL || !treeStack.empty()) {
		while (cur != NULL) {
			treeStack.push(cur);
			cur = cur->left;
		}

		result.push_back(treeStack.top()->val);     //44�д�����50�д������һ��һ��һ���Ļ����ϵ��
		cur = treeStack.top()->right;				//���Բ�����cur != NULL,����treeStack is empty�Ĺ�ϵ�����ǲ�����treeStackΪ�ջ�pop�Ĳ���
		treeStack.pop();
	}

	return result;
}

/*
int main()
{

	return 0;
}
*/