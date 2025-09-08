class Solution {
    static final int MOD = 1_000_000_007;
    public int countGoodNumbers(long n) {
        long pow5 = modPow(5, (n + 1) / 2, MOD);
        long pow4 = modPow(4, n / 2, MOD);
        return (int) ((pow5 * pow4) % MOD);
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}