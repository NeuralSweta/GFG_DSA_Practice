// Problem: Max Consecutive Ones | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/max-consecutive-one/0
class Solution {
    public int maxConsecutiveOnes(int[] arr) {
        int maxCount = 0, count = 0;
        for (int x : arr) {
            count = (x == 1) ? count + 1 : 0;
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
