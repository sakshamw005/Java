class Solution {
    public int longestMountain(int[] arr) {
        if(arr.length < 3) return 0;

        int ans = 0;

        for(int i = 1 ; i < arr.length - 1 ; i++){
            if(arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                ans = Math.max(ans, find(i, arr));
            }
        }

        return ans;
    }

    public int find(int i, int[] arr){
        int l = i;
        int r = i;

        int x = i - 1;
        while(x >= 0 && arr[x] < arr[x+1]){
            l = x;
            x--;
        }

        x = i + 1;
        while (x < arr.length && arr[x] < arr[x - 1]) {
            r = x;
            x++;
        }


        return r - l + 1;
    }
}