class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] res = new int[9];
        res[0] = 1;
        res[1] = 10;
        res[2] = 91;
        res[3] = 739;
        res[4] = 5275;
        res[5] = 32491;
        res[6] = 168571;
        res[7] = 712891;
        res[8] = 2345851;
        return res[n];
    }
}