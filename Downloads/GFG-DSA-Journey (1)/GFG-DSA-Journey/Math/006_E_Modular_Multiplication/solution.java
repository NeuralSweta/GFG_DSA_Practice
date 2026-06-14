// Problem: Modular Multiplication | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/modular-multiplication/0
class Solution {
    static final int MOD = 1_000_000_007;
    public long multiplyMod(long a, long b) {
        return (a % MOD * (b % MOD)) % MOD;
    }
}
