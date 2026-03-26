class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int start = 0;
        int mid = k-1;
        int end = nums.length-1;
        
        reverse(nums, 0, end);
        reverse(nums, 0, mid);
        reverse(nums, mid+1, end);
    }
    private void reverse(int[] arr, int left, int right){
        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}