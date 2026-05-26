class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    
    public void helper(int[] candidates, int target, int index, List<Integer> curr, List<List<Integer>> ans) {
        if(target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target < 0 || index == candidates.length) {
            return;
        }

        curr.add(candidates[index]);
        helper(candidates, target-candidates[index], index, curr, ans);
        curr.remove(curr.size() - 1);

        helper(candidates, target, index+1, curr, ans);
    }
    
}