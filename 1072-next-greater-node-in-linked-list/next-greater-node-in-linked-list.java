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
    public int[] nextLargerNodes(ListNode head) {
        List<Integer> ll = new ArrayList<>() ;
        while(head!=null){
            ll.add(head.val) ;
            head = head.next ; 
        }
        int[] ans = new int[ll.size()] ;
        Stack<Integer> st = new Stack<>() ;
        for(int i = ll.size()-1 ; i>=0 ; i--){
            while(!st.isEmpty() && ll.get(i)>=st.peek()){
                st.pop() ;
            }
            ans[i] = st.isEmpty()? 0  :  st.peek() ;
            st.push(ll.get(i)) ;
        }
        return ans ;
    }
}