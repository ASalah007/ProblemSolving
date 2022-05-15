public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        while(head.next != null){
            if(head.val == Integer.MIN_VALUE)
                return true;
            head.val=Integer.MIN_VALUE;
            head = head.next;
        }
        return false;
    }
}
