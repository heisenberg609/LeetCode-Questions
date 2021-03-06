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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        int carry = 0;
        
        ListNode result = null;
        
        while(!stack1.isEmpty() || !stack2.isEmpty()) {
            
            int l1_val = 0, l2_val = 0;
            
            if(!stack1.isEmpty())
                l1_val = stack1.pop();
            
            if(!stack2.isEmpty())
                l2_val = stack2.pop();
            
            int total = l1_val + l2_val + carry;
            
            ListNode temp = new ListNode(total%10);
            
            carry = total / 10;
            
            if(result == null)
                result = temp;
            else {
                temp.next = result;
                result = temp;
            }
        }
        
        if(carry != 0) {
            ListNode temp = new ListNode(carry);
            temp.next = result;
            result = temp;
        }
        
        return result;
    }
}
