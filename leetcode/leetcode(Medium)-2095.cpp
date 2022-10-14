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
    ListNode* deleteMiddle(ListNode* head) {
        if (head == nullptr || head->next == nullptr){
            return nullptr;
        } 
        int sz = 0;
        ListNode* temp = head;
        while(temp != nullptr){
            sz++;
            temp = temp -> next;
        }
        int md = sz / 2;
        
        temp = head;
        while(md-- > 1){
            temp = temp -> next;
        }
        
        ListNode* afterNext = temp->next->next;
        temp->next->next = nullptr;
        delete temp->next;
        temp->next = afterNext;
        return head;
    }
};
