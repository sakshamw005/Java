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
    public ListNode deleteDuplicates(ListNode head) {
        Map<Integer, Integer> map = new HashMap<>();

        ListNode dummy = head;
        while (dummy != null) {
            map.put(dummy.val, map.getOrDefault(dummy.val, 0) + 1);
            dummy = dummy.next;
        }
        ListNode ans = new ListNode(0);
        ListNode tail = ans;

        dummy = head;
        while (dummy != null) {
            if (map.get(dummy.val) == 1) {
                tail.next = dummy;
                tail = tail.next;
            }
            dummy = dummy.next;
        }
        tail.next = null;

        return ans.next;
    }
}