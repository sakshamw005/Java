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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr) return head;

        int size = getSize(head);
        k %= size;
        if (k == 0) return head;

        int newHeadPosition = size - k;

        ListNode* temp = head;
        for (int i = 1; i < newHeadPosition; i++) {
            temp = temp->next;
        }

        ListNode* newHead = temp->next;
        temp->next = nullptr;

        ListNode* lastNode = getLastNode(newHead);
        lastNode->next = head;

        return newHead;
    }

private:
    int getSize(ListNode* head) {
        int count = 0;
        ListNode* temp = head;
        while (temp != nullptr) {
            count++;
            temp = temp->next;
        }
        return count;
    }

    ListNode* getLastNode(ListNode* head) {
        ListNode* temp = head;
        while (temp->next != nullptr) {
            temp = temp->next;
        }
        return temp;
    }
};