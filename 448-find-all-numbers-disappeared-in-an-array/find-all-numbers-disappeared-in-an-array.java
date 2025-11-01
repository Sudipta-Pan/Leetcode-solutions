class Solution {
    // google interview question
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[correct] != nums[i]) {
                swap(nums, correct, i);
            } else {
                i++;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int j = 0; j<nums.length; j++) {
            if (nums[j] != j+1) {
                result.add(j+1);
            }
        }
        return result;
    }

    void swap(int[] arr,int a, int b) {
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
        }
}