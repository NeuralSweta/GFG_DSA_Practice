// Problem: Prime Number | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/prime-number2314/0
class Solution {
    public boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++)
            if (n % i == 0) return false;
        return true;
    }
}
