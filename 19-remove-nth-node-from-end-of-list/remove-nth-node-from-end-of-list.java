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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0 ;
        ListNode x = head ;
        while(x!=null){
            length++ ;
            x = x.next ;
        }
        if(n==length){
            return head.next ;
        }
        int target = length - n ;
        int pos = 0 ;
        ListNode current = head;
        while (current != null) {
            pos++;
            if (pos == target) {
                current.next = current.next.next;
                break;
            }
            current = current.next;
        }
        return head;
    }
}