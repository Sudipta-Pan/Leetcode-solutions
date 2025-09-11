class Solution {
    public int findNumbers(int[] nums) {
        int evendigit = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            String str = String.valueOf(num);
            int digit = str.length();
            if (digit % 2 == 0)
                evendigit++;
        }
        return evendigit;
    }
}