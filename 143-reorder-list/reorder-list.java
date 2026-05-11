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
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;

        ListNode mid = middleNode(head);
        ListNode headSec = reverseList(mid);
        ListNode headFir = head;
        while(headSec != null && headFir != null) {
            ListNode temp = headFir.next;
            headFir.next = headSec;
            headFir = temp;

            temp = headSec.next;
            headSec.next = headFir;
            headSec = temp;
        }
        if(headFir != null)
            headFir.next = null;
    }
    public ListNode middleNode(ListNode head) {
        ListNode s = head;
        ListNode f = head;
        while(f != null && f.next != null){
            f = f.next.next;
            s = s.next;
        }
        return s;
    }
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode present = head;
        ListNode next = null;

        while(present != null){
            next = present.next;
            present.next = prev;
            prev = present;
            present = next;
            if(next != null)
                next = next.next;
        }
        return prev;
    }
}