class Solution {

    static String[] map = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return list;
        }

        solve("", digits, list);
        return list;
    }

    static void solve(String p, String up, List<String> list) {
        if (up.isEmpty()) {
            list.add(p);
            return;
        }

        int digit = up.charAt(0) - '0';
        String letters = map[digit];

        for (int i = 0; i < letters.length(); i++) {
            solve(p + letters.charAt(i), up.substring(1), list);
        }
    }
}