// Problem: Armstrong Numbers | Difficulty: Easy | Topic: Math
// GFG: https://www.geeksforgeeks.org/problems/armstrong-numbers2727/0
class Solution {
    public boolean armstrongNumber(int n) {
        int digits = String.valueOf(n).length(), sum = 0, temp = n;
        while (temp > 0) {
            int d = temp % 10;
            sum += (int) Math.pow(d, digits);
            temp /= 10;
        }
        return sum == n;
    }
}
