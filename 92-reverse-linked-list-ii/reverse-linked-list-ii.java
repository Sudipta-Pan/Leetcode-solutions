class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || left == right) {
            return head;
        }

        ListNode current = head;
        ListNode prev = null;

        // Reach left position
        for (int i = 1; i < left; i++) {
            prev = current;
            current = current.next;
        }

        // Store connections
        ListNode last = prev;
        ListNode newEnd = current;

        // Reverse part
        ListNode next = current.next;
        ListNode tempPrev = null;

        for (int i = 0; i <= right - left; i++) {

            current.next = tempPrev;
            tempPrev = current;
            current = next;

            if (next != null) {
                next = next.next;
            }
        }

        // Connect first part
        if (last != null) {
            last.next = tempPrev;
        } else {
            head = tempPrev;
        }

        // Connect last part
        newEnd.next = current;

        return head;
    }
}