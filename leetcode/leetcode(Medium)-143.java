class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode mid = getMid(head);
        ListNode rev = reverse(mid);
        alternate(head, rev);
    }

    private ListNode getMid(ListNode head){
        ListNode first = head, second = head;

        while (true){
            if (second == null) return first;
            else if (second.next == null) return first.next;

            first = first.next;
            second = second.next.next;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode f = head, s = head.next;
        f.next = null;
        while(s != null) {
            ListNode temp = s.next;
            s.next = f;
            f = s;
            s = temp;
        }
        return f;
    }

    private void alternate(ListNode h1, ListNode h2){ 
        if(h1 == null) return;
        if (h2 == null) {h1.next = null; return;};
        ListNode temp = h1.next;
        h1.next = h2;
        h1 = temp;
        alternate(h2, h1);
    }
}
