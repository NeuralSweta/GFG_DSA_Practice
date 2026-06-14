// Problem: Array Leaders | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/0
import java.util.*;
class Solution {
    public List<Integer> leaders(int[] arr) {
        List<Integer> result = new ArrayList<>();
        int maxRight = arr[arr.length - 1];
        result.add(maxRight);
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] >= maxRight) { maxRight = arr[i]; result.add(0, arr[i]); }
        }
        return result;
    }
}
