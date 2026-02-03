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
    public ListNode doubleIt(ListNode head) {
        int s = solve(head) ;
        if(s!=0){
            ListNode l = new ListNode(s) ;
            l.next = head ;
            return l ;
        }
        return head ;
    }
    public int solve(ListNode head){
        if(head==null)return 0 ;
        int c = solve(head.next) ;
        int val = head.val*2 + c ;
        head.val = val%10 ;
        return val/10 ;
    }
}