class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;
        
        ListNode n = head, nn=head.next;
        
        if(n.val == nn.val){
          return deleteDuplicates(skip(nn.val, nn));  
        } 
        
        n.next = deleteDuplicates(nn);
        return n;
    }
    
    private ListNode skip(int val, ListNode head){
        while(head != null && head.val == val) head = head.next;
        return head;
    }
}
