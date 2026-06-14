// Problem: Longest Subarray with Sum K | Difficulty: Medium | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/0
import java.util.*;
class Solution {
    public int lenOfLongSubarr(int[] arr, int k) {
        Map<Long, Integer> prefixMap = new HashMap<>();
        long prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];
            if (prefixSum == k) maxLen = i + 1;
            if (prefixMap.containsKey(prefixSum - k))
                maxLen = Math.max(maxLen, i - prefixMap.get(prefixSum - k));
            prefixMap.putIfAbsent(prefixSum, i);
        }
        return maxLen;
    }
}
