package g0201_0300.s0275_h_index_ii;

public class Solution {
    public int hindex(int[] citations) {
        int lo = 1;
        int hi = 1000;
        int ans = 0;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int p = check(mid, citations);
            if (citations.length - p >= mid) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private int check(int v, int[] arr) {
        int lo = 0;
        int hi = arr.length - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < v) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
