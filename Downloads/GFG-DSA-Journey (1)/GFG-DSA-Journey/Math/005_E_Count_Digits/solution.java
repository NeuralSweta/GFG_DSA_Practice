// Problem: Count Digits in a Number | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/count-total-digits-in-a-number/0
class Solution {
    public int countDigits(int n) {
        int count = 0;
        while (n > 0) { count++; n /= 10; }
        return count;
    }
}
