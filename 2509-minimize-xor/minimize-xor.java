class Solution {
    public int minimizeXor(int num1, int num2) {
        int x = 0;
        int setbit = Integer.bitCount(num2);

        for (int i = 30; i >= 0 && setbit > 0; i--) {
            int mask = (1 << i);
            if ((num1 & mask) != 0) {
                x |= mask;
                setbit--;
            }
        }
        for (int i = 0; i <= 30 && setbit > 0; i++) {
            int mask = (1 << i);
            if ((num1 & mask) == 0) {
                x |= mask;
                setbit--;
            }
        }

        return x;
    }
}