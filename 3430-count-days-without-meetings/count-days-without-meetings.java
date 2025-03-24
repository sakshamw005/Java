class Solution {
    public int countDays(int days, int[][] meetings) {
        if (meetings.length == 0) return days;

        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] arr = meetings[0];

        for (int i = 1; i < meetings.length; i++) {
            int end = arr[1];
            int startNext = meetings[i][0];
            int endNext = meetings[i][1];

            if (startNext <= end) { 
                arr[1] = Math.max(end, endNext);
            } else {
                merged.add(arr);
                arr = meetings[i];
            }
        }
        merged.add(arr);

        int occupied = 0;
        for (int[] m : merged) {
            occupied += (m[1] - m[0] + 1);
        }
        return days - occupied;
    }
}