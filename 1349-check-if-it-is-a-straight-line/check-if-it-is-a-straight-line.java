class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates[1][0] - coordinates[0][0] == 0) {
            for (int i = 1; i < coordinates.length; i++) {
                if (coordinates[i][0] != coordinates[0][0]) {
                    return false;
                }
            }
            return true;
        }
        double slope = (double)(coordinates[1][1]-coordinates[0][1])/(coordinates[1][0]-coordinates[0][0]);
         for (int i = 1; i < coordinates.length - 1; i++) {
            double x = (double) (coordinates[i + 1][1] - coordinates[i][1]) / 
                           (coordinates[i + 1][0] - coordinates[i][0]);
            if (slope != x) {
                return false ;
            }
        }
        return true ;
    }
}