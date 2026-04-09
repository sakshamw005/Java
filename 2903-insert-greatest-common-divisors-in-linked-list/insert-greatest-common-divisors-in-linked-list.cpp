/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* insertGreatestCommonDivisors(ListNode* head) {
        ListNode* dummy = head;

        while (head != NULL && head->next != NULL) {
            int g = gcd(head->val, head->next->val);
            ListNode* n = new ListNode(g);
            ListNode* temp = head->next;
            head->next = n;
            n->next = temp;
            head = temp; 
        }
        return dummy;
    }
    int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
};