// Problem: Fibonacci Number (Memoized Recursion)
// Difficulty: Easy | Topic: Recursion / DP
// GFG Link: https://www.geeksforgeeks.org/problems/fibonacci-using-memoization-1587115620/1

import java.util.*;

class Solution {
    Map<Integer, Long> memo = new HashMap<>();

    public long fib(int n) {
        if (n <= 1) return n;
        if (memo.containsKey(n)) return memo.get(n);
        long result = fib(n - 1) + fib(n - 2);
        memo.put(n, result);
        return result;
    }
}
