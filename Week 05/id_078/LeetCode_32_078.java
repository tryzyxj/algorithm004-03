//����һ��ֻ���� '(' �� ')' ���ַ������ҳ���İ�����Ч���ŵ��Ӵ��ĳ��ȡ� 
//
// ʾ�� 1: 
//
// ����: "(()"
//���: 2
//����: ���Ч�����Ӵ�Ϊ "()"
// 
//
// ʾ�� 2: 
//
// ����: ")()())"
//���: 4
//����: ���Ч�����Ӵ�Ϊ "()()"
// 
// Related Topics �ַ��� ��̬�滮



//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestValidParentheses(String s) {
        int answer = 0;
        int dp[] = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                answer = Math.max(answer, dp[i]);
            }
        }
        return answer;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
