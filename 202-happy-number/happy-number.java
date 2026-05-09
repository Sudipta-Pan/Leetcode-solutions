class Solution {
    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;
        fast = findSquare(findSquare(fast));
        slow = findSquare(slow);
        while(fast != slow){
        fast = findSquare(findSquare(fast));
        slow = findSquare(slow);    
        }

        if(slow == 1)
            return true;
        return false;
    }
    private int findSquare(int number){
        int ans = 0;
        while(number > 0){
            int rem = number % 10;
            ans += rem * rem;
            number /= 10;
        }
        return ans;
    }
}