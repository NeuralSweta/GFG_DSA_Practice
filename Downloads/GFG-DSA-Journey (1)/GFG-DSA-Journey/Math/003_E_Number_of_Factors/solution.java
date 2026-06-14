// Problem: Number of Factors | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/number-of-factors1435/0
class Solution {
    public int numFactors(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) count += (i == n / i) ? 1 : 2;
        }
        return count;
    }
}
