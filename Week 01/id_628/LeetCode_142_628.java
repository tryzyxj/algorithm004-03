import java.util.HashSet;
import java.util.Set;

import com.leetCode.exercise.struct.ListNode;

//����һ��������������ʼ�뻷�ĵ�һ���ڵ㡣 ��������޻����򷵻� null�� 
//
//Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� ��� pos �� -1�����ڸ�������û�л��� 
//
//˵�����������޸ĸ��������� 
//
//
//
//ʾ�� 1�� 
//
//���룺head = [3,2,0,-4], pos = 1
//�����tail connects to node index 1
//���ͣ���������һ��������β�����ӵ��ڶ����ڵ㡣
//
//
//
//
//ʾ�� 2�� 
//
//���룺head = [1,2], pos = 0
//�����tail connects to node index 0
//���ͣ���������һ��������β�����ӵ���һ���ڵ㡣
//
//
//
//
//ʾ�� 3�� 
//
//���룺head = [1], pos = -1
//�����no cycle
//���ͣ�������û�л���
//
//
//
//
//
//
//���ף� 
//���Ƿ���Բ��ö���ռ������⣿ 
//Related Topics ���� ˫ָ��



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
	public ListNode detectCycle(ListNode head) {
		detectCycle1(head);
    }
	/**
	 * ��˼·������ָ�뷨��
	 * 		 ��ʹ�ÿ���ָ��������ʶ��������Ȼ������ο����������ָ����㻷����ڽڵ�
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
	 * ��ʱ�临�Ӷȡ�O(n+k) 
	 * ���ռ临�Ӷȡ�O(1)
	 * @param head ԭʼ����ͷ���
	 * @return <ListNode> �뻷�ڵ��null
	 */
	public ListNode detectCycle1(ListNode head) {
		if (null == head || head.next == null)
			return null;
		ListNode fastNode = head.next.next;// ��ָ��
		ListNode slowNode = head.next;// ��ָ��
		while (fastNode != slowNode) {
			if (fastNode == null || null == fastNode.next)
				return null;
			fastNode = fastNode.next.next;
			slowNode = slowNode.next;
		}
		//��ʱ˵���л���Ȼ�󹹽����ָ�룬����������ָ��ͬ���ߣ���������ʱ��Ϊ�뻷λ�á�
		ListNode zeroNode = head;// ����ָ��
		while(zeroNode != slowNode) {
			zeroNode = zeroNode.next;
			slowNode = slowNode.next;
		}
		return zeroNode;
	}
	
	/**
	 * ��˼·�������¼����
	 *         ����һ������ÿ�������뻺��set�У��ж��Ƿ�������˽ڵ�ȷ���Ƿ��л������л����ش˽ڵ㣬���޻�����null
	 * ��ʱ�临�Ӷȡ�O(n) 
	 * ���ռ临�Ӷȡ�O(n)
	 * @param head ԭʼ����ͷ���
	 * @return <ListNode> �뻷�ڵ��null
	 */
	public ListNode detectCycle2(ListNode head) {
		Set<ListNode> cacheSet = new HashSet<ListNode>();
		while (!cacheSet.contains(head)) {
			if (head == null)
				return null;
			cacheSet.add(head);
			head = head.next;
		}
		return head;
	}
}
//leetcode submit region end(Prohibit modification and deletion)
