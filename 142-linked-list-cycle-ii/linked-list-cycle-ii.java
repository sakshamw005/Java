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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode Fast=head;
        while(Fast!=null && Fast.next!=null){
            slow=slow.next;
            Fast=Fast.next.next;
            if(slow==Fast){
                ListNode temp = head ;
                while(temp!=slow){
                    temp = temp.next ;
                    slow = slow.next ;
                }
                return temp ;
            }
        }
        return null;
    }
}