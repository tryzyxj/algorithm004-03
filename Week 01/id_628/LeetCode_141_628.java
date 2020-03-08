import java.util.HashSet;
import java.util.Set;

import com.leetCode.exercise.struct.ListNode;

//����һ�������ж��������Ƿ��л��� 
//
// Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л��� 
//
// 
//
// ʾ�� 1�� 
//
// ���룺head = [3,2,0,-4], pos = 1
//�����true
//���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
// 
//
// 
//
// ʾ�� 2�� 
//
// ���룺head = [1,2], pos = 0
//�����true
//���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
// 
//
// 
//
// ʾ�� 3�� 
//
// ���룺head = [1], pos = -1
//�����false
//���ͣ�������û�л���
// 
//
// 
//
// 
//
// ���ף� 
//
// ������ O(1)�������������ڴ����������� 
// Related Topics ���� ˫ָ��



//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class LeetCode_141_628 {
    public boolean hasCycle(ListNode head) {
    	hasCycle1(head);
    }
    /**
	 * ��˼·������ָ�롣
	 *         ���ÿ�ָ������ָ��ͬ�������������л���������߻����������Խ��� 
	 *         
	 *     ��ʹ�ÿ���ָ��������ʶ��������Ȼ������ο����������ָ����㻷����ڽڵ�
	 * 		  ����ָ������ʱ
	 *         ��ָ���߹��� p=a+x+n*(x+y)
	 *         ��ָ���߹���2p=a+x+m*(x+y)
	 *       ��ʽ�ϲ��ɵã�
	 *         a=(m-2n)(x+y)-x
	 *         a=(m-2n-1)(x+y)+y
	 *         ����x+y�ǻ��ĳ��ȣ�Ϊ��ֵ��
	 *         Ҳ������ָ������a���Ļ����൱������m-2n-1Ȧ�Լ�y������ʱ��ָ�뽫�ص�A��
	 *       �ʶ�Ϊ������ָ���ߵĲ�����a����
	 *       ��������ο�ָ��-���ָ�룬ʹ�����㿪ʼ����ָ���B�㿪ʼͬʱ��������ÿ����һ���ڵ㣬
	 *       ��ָ����a���󵽴�A�㣬���ָ����a��Ҳ����A��
	 *       ����ָ�뽫ͬʱ�ߵ�A�㣬����A������,��ʱ���ָ��ָ��ڵ㼴Ϊ����ڵ㡣     
	 *         
	 *    
	 * ��ʱ�临�Ӷȡ�O(n+k) 
	 * ���ռ临�Ӷȡ�O(1)
	 * @param head	ԭʼ����ͷ���
	 * @return <boolean> true-���ڻ� false-�����ڻ�
	 */
	public static boolean hasCycle1(ListNode head) {
		if (null == head || head.next == null)
			return false;
		ListNode fastNode = head.next.next;// ��ָ��
		ListNode slowNode = head.next;// ��ָ��
		while (fastNode != slowNode) {
			if (fastNode == null || null == fastNode.next)
				return false;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		return true;
	}
	
	/**
	 * ��˼·�������¼����
	 *      ����һ������ÿ�������뻺��set�У��ж��Ƿ�������˽ڵ�ȷ���Ƿ��л�
	 * ��ʱ�临�Ӷȡ�O(n) 
	 * ���ռ临�Ӷȡ�O(n)
	 * @param head ԭʼ����ͷ���
	 * @return <boolean> true-���ڻ� false-�����ڻ�
	 */
	public static boolean hasCycle2(ListNode head) {
		Set<ListNode> cacheSet = new HashSet<ListNode>();
		while (!cacheSet.contains(head)) {
			if (head == null)
				return false;
			cacheSet.add(head);
			head = head.next;
		}
		return true;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
