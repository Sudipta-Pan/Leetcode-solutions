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

        // STEP 1: Find middle
        ListNode mid = middleNode(head);

        // STEP 2: Reverse second half
        ListNode headSecond = reverseList(mid.next);

        // Break the list
        mid.next = null;

        // STEP 3: Merge both halves
        ListNode headFirst = head;

        while(headSecond != null){

            ListNode temp1 = headFirst.next;
            ListNode temp2 = headSecond.next;

            headFirst.next = headSecond;
            headSecond.next = temp1;

            headFirst = temp1;
            headSecond = temp2;
        }
    }

    public ListNode middleNode(ListNode head) {

        ListNode s = head;
        ListNode f = head;

        while(f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }

        return s;
    }

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode present = head;

        while(present != null){

            ListNode next = present.next;

            present.next = prev;

            prev = present;
            present = next;
        }

        return prev;
    }
}