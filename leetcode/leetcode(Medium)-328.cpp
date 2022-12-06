class Solution {
 public:
  ListNode* oddEvenList(ListNode* head) {
    if (!head || !head->next) {
      return head;
    }

    ListNode *odd = head, *even = head->next, *e = head->next;
    while (even->next) {
      odd->next = even->next;
      odd = odd->next;

      if (!odd->next) break;
      even->next = odd->next;
      even = even->next;
    }
    even->next = NULL;
    odd->next = e;
    return head;
  }
};
