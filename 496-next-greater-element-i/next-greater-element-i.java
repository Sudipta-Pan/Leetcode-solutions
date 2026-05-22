class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Map to store: element -> its next greater element
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        // Process nums2 from right to left
        for (int i = nums2.length - 1; i >= 0; i--) {
            int num = nums2[i];
            
            // Pop elements from the stack that are smaller than or equal to the current number
            while (!stack.isEmpty() && stack.peek() <= num) {
                stack.pop();
            }
            
            // If stack is empty, there is no greater element to the right. Otherwise, it's the top element.
            if (stack.isEmpty()) {
                map.put(num, -1);
            } else {
                map.put(num, stack.peek());
            }
            
            // Push the current number onto the stack for future elements to check
            stack.push(num);
        }
        
        // Build the result array for nums1 using our map lookups
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }
        
        return result;
    }
}