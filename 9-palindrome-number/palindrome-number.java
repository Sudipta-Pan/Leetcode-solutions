class Solution {
    public boolean isPalindrome(int x) {
        int sum = 0;
        int temp = x;
        if (x < 0)
            return false;
        while(temp  != 0) {
            int r = temp%10;
            sum = sum*10 + r;
            temp /= 10;
        }
        return sum == x;
    }
}