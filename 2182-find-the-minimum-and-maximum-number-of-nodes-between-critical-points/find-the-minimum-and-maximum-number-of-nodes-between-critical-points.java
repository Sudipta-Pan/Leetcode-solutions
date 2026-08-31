class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int[] ans = {-1, -1};

        if (head == null || head.next == null || head.next.next == null) {
            return ans;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        int first = -1;
        int last = -1;

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = -1;

        while (curr.next != null) {

            int prevValue = prev.val;
            int currValue = curr.val;
            int nextValue = curr.next.val;

            // Check whether current node is a critical point
            boolean isCritical =
                    (currValue > prevValue && currValue > nextValue) ||
                    (currValue < prevValue && currValue < nextValue);

            if (isCritical) {

                // First critical point
                if (first == -1) {
                    first = position;
                } 
                else {
                    // Distance from previous critical point
                    minDistance = Math.min(minDistance, position - last);

                    // Distance from first critical point
                    maxDistance = position - first;
                }

                last = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        if (maxDistance == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDistance, maxDistance};
    }
}