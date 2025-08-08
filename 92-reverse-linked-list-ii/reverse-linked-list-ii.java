/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if((left==right) || (head==null))return head ;
        ListNode dummy = new ListNode(0) ;
        dummy.next = head ;

        ListNode nbl = dummy ;
        for(int i = 1 ; i<left ; i++){
            nbl = nbl.next ;
        }

        ListNode start = nbl.next , then = start.next ;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = nbl.next;
            nbl.next = then;
            then = start.next;
        } 
        return dummy.next ;
    }
}