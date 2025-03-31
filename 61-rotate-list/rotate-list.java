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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        int size = getSize(head);
        k %= size;
        if (k == 0) return head;
        int newHeadPosition = size - k;
        ListNode temp = head;
        for (int i = 1; i < newHeadPosition; i++) {
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;
        ListNode lastNode = getLastNode(newHead);
        lastNode.next = head;
        return newHead;
    }
    private int getSize(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }
    private ListNode getLastNode(ListNode head) {
        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        return temp;
    }
}