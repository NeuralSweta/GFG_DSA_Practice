// Problem: Intersection of Arrays | Difficulty: Easy | Topic: Arrays
// GFG: https://www.geeksforgeeks.org/problems/intersection-of-two-arrays2404/0
import java.util.*;
class Solution {
    public int[] intersection(int[] a, int[] b) {
        Set<Integer> set = new HashSet<>();
        for (int x : a) set.add(x);
        List<Integer> res = new ArrayList<>();
        for (int x : b) if (set.contains(x)) { res.add(x); set.remove(x); }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
