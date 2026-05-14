/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode temp = node;
        
            if(temp.val == node.val){
                node.val = temp.next.val;
                temp.next = temp.next.next;
            }
            

        
    }
}