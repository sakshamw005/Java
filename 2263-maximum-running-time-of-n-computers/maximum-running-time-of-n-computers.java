class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long sum = 0;
        for (int b : batteries) sum += b;

        long low = 0, high = sum / n; 

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canRun(mid, batteries, n)) {
                low = mid + 1; 
            } else {
                high = mid - 1;  
            }
        }
        return high;  
    }

    private boolean canRun(long T, int[] batteries, int n) {
        long total = 0;

        for (int b : batteries) {
            total += Math.min((long)b, T);
        }

        return total >= T * n;
    }
}
