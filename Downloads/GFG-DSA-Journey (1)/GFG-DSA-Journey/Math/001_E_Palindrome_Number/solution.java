// Problem: Palindrome Number | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/palindrome0746/0
class Solution {
    public boolean isPalindrome(int n) {
        if (n < 0) return false;
        int original = n, reversed = 0;
        while (n > 0) { reversed = reversed * 10 + n % 10; n /= 10; }
        return original == reversed;
    }
}
