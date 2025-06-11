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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        
        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        ListNode ans = null; 
        
        while (!s1.isEmpty() || !s2.isEmpty() || carry != 0) {
            if (!s1.isEmpty()) carry += s1.pop();
            if (!s2.isEmpty()) carry += s2.pop();
            
            int temp = carry % 10;
            carry = carry / 10;
            
            ListNode x = new ListNode(temp);
            x.next = ans;
            ans = x;
        }
        
        return ans;
    }
}