package g0001_0100.s0042_trapping_rain_water;

// #Hard #Top_100_Liked_Questions #Top_Interview_Questions #Array #Dynamic_Programming #Two_Pointers
// #Stack #Monotonic_Stack #Dynamic_Programming_I_Day_9 #Udemy_Two_Pointers
// #2022_06_16_Time_1_ms_(98.06%)_Space_42.9_MB_(90.96%)

public class Solution {
    public int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = 0;
        int lowerWall = 0;
        while (l < r) {
            int lVal = height[l];
            int rVal = height[r];
            // If left is smaller than right ptr, make the lower wall the bigger of lVal and its
            // current size
            if (lVal < rVal) {
                // If lVal has gone up, move the lowerWall upp
                lowerWall = Math.max(lVal, lowerWall);
                // Add the water level at current point
                // Calculate this by taking the current value and subtracting it from the lower wall
                // size
                // We know that this is the lower wall because we've already determined that lVal <
                // rVal
                res += lowerWall - lVal;
                // Move left ptr along
                l++;
            } else {
                // Do the same thing, except now we know that the lowerWall is the right side.
                lowerWall = Math.max(rVal, lowerWall);
                res += lowerWall - rVal;
                r--;
            }
        }
        return res;
    }
}
