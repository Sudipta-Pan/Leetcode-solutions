/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        int length = findLength(head);
        if(length == 0)
            return null;

        ListNode f = head;
        ListNode s = head;
        for(int i=0; i<length; i++){
            f = f.next;
        }
        while(f != s){
            f = f.next;
            s = s.next;
        }
        return f;

    }
    public int findLength(ListNode head){
        ListNode f = head;
        ListNode s = head;
        int len = 1;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
            if(f == s){
                f = f.next;
                while(f != s){
                    f = f.next;
                    len++;
                }
                return len;
            }
        }
        return 0;
    }
}