class Solution {
    public boolean isPalindrome(String s) {
        String ans = s.toLowerCase().replaceAll("[^a-z0-9]", "");

        if(ans.equals(""))
            return true;

        int i = 0;
        int j = ans.length()-1;

        while(i < j){
            if(ans.charAt(i) != ans.charAt(j))
                return false;
            i++;
            j--;
        } 
        return true;
    }
}