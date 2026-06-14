// Problem: Longest Consecutive Subsequence | Difficulty: Medium | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/0
import java.util.*;
class Solution {
    public int longestConsecutive(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) set.add(x);
        int maxLen = 0;
        for (int x : set) {
            if (!set.contains(x - 1)) {        // start of a chain
                int len = 1;
                while (set.contains(x + len)) len++;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
}
