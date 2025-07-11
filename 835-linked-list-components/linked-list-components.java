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
    public int numComponents(ListNode head, int[] nums) {
        Set<Integer> s = new HashSet<>() ;
        for(int i : nums)s.add(i) ;
        int ans = 0 ; 
        while(head!=null){
            if(s.contains(head.val) && (head.next==null || !s.contains(head.next.val))){
                ans++ ;
            }
            head=head.next ;
        }
        return ans ;
    }
}