//��������������ϲ�Ϊһ���µ������������ء���������ͨ��ƴ�Ӹ�����������������нڵ���ɵġ� 
//
//ʾ���� 
//
//���룺1->2->4, 1->3->4
//�����1->1->2->3->4->4
//
//Related Topics ����



//leetcode submit region begin(Prohibit modification and deletion)
/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode(int x) { val = x; }
* }
*/
class LeetCode_21_628 {
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if(l1 == null) return l2;
      if(l2 == null) return l1;
      ListNode res = new ListNode(-1) ;
      ListNode cur = res ;
      while (l1 != null || l2 != null){
          if(l1 == null){
              cur.next = l2 ;
              l2 = l2.next;
          }else if(l2 == null || l1.val <= l2.val){
              cur.next = l1 ;
              l1 = l1.next;
          }else{
              cur.next = l2 ;
              l2 = l2.next;
          }
          cur = cur.next;
      }
      return res.next ;

  }
}
//leetcode submit region end(Prohibit modification and deletion)

//�����ִ���㡿
//1��δ���ǵ�l1Ϊ�յ������l2Ϊ��������Ⱥ�˳��
//2��δ���ǵ������l1��l2��ͷ�����Ϊ��ʼ���Ļ����ᵼ��ѭ��ָ����֡�
