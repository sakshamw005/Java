class Solution {
    public String complexNumberMultiply(String num1, String num2) {
        int r1 = find(num1), r2 = find(num2);
        int i1 = imz(num1), i2 = imz(num2);

        int real = r1 * r2 - i1 * i2;
        int imag = r1 * i2 + r2 * i1;

        StringBuilder ans = new StringBuilder();
        ans.append(real);
        ans.append('+');
        ans.append(imag);
        ans.append('i');
        return ans.toString();
    }
    public static int find(String num) {
        int plusIndex = num.indexOf('+');
        return Integer.parseInt(num.substring(0, plusIndex));
    }
    public static int imz(String num) {
        int plusIndex = num.indexOf('+');
        int iIndex = num.indexOf('i');
        return Integer.parseInt(num.substring(plusIndex + 1, iIndex));
    }
}