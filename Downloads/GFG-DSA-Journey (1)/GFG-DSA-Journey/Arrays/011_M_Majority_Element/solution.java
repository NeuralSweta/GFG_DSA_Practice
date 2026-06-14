// Problem: Majority Element | Difficulty: Medium | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/majority-element-1587115620/0
class Solution {
    public int majorityElement(int[] arr) {
        int candidate = arr[0], count = 1;
        // Phase 1: Boyer-Moore voting
        for (int i = 1; i < arr.length; i++) {
            if (count == 0) { candidate = arr[i]; count = 1; }
            else if (arr[i] == candidate) count++;
            else count--;
        }
        // Phase 2: Verify
        count = 0;
        for (int x : arr) if (x == candidate) count++;
        return count > arr.length / 2 ? candidate : -1;
    }
}
