
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return null;
        if(k == 0) return head;

        int size=1;
        ListNode tail = head;
        
        while(tail.next != null){
            tail= tail.next;
            size++;
        }

        k %= size;
        if(k == 0) return head;

        int newTailIndex = size - k;
        ListNode newTail = head;
        
        for(int i =0; i<newTailIndex-1; i++){
            newTail = newTail.next;
        }

        tail.next = head;
        head = newTail.next;
        newTail.next = null;

        return head;
    }
}
