class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] arr = new int[nums1.length];
        int x = 0;
        boolean bool = true;

        for(int i = 0; i < nums1.length; i++) {
        
            for(int j = 0; j<nums2.length; j++) {
        
                if(nums1[i] == nums2[j]){
                    bool = true;
        
                    for(int k = j+1; k < nums2.length; k++){
        
                        if(nums2[k] > nums2[j]){
                            arr[x++] = nums2[k];
                            bool = false;
                            break;
                        }
                    }
                    if(bool)
                        arr[x++] = -1;
                }
            }
        }
        return arr;
    }
}