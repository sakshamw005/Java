class Solution {
    public double[] medianSlidingWindow(int[] nums, int k) {
        return find(nums,k);
    }

    public double[] find(int[] arr ,int k){
        double[] ans = new double[arr.length-k+1];

        TreeMap<Integer,Integer> max = new TreeMap<>();
        TreeMap<Integer,Integer> min = new TreeMap<>();

        int maxSize = 0, minSize = 0;

        java.util.function.BiConsumer<TreeMap<Integer,Integer>, Integer> add = (map, val) -> {
            map.put(val, map.getOrDefault(val, 0) + 1);
        };

        java.util.function.BiConsumer<TreeMap<Integer,Integer>, Integer> remove = (map, val) -> {
            if(map.get(val) == 1) map.remove(val);
            else map.put(val, map.get(val) - 1);
        };

        for(int i = 0 ; i<k ; i++){
            add.accept(min, arr[i]);
            minSize++;
        }

        while(maxSize < (k+1)/2){
            int x = min.firstKey();
            remove.accept(min, x);
            minSize--;
            add.accept(max, x);
            maxSize++;
        }

        if(k%2==0){
            ans[0] = ((double)max.lastKey() + min.firstKey())/2;
        } else {
            ans[0] = (double)max.lastKey();
        }

        int l = 1 , r = k ;
        int idx = 1 ;

        while(r < arr.length){
            int out = arr[l-1];
            int in = arr[r];

            if(max.containsKey(out)){
                remove.accept(max, out);
                maxSize--;
            } else {
                remove.accept(min, out);
                minSize--;
            }

            if(maxSize == 0 || in <= max.lastKey()){
                add.accept(max, in);
                maxSize++;
            } else {
                add.accept(min, in);
                minSize++;
            }

            while(maxSize > minSize + 1){
                int x = max.lastKey();
                remove.accept(max, x);
                maxSize--;
                add.accept(min, x);
                minSize++;
            }

            while(minSize > maxSize){
                int x = min.firstKey();
                remove.accept(min, x);
                minSize--;
                add.accept(max, x);
                maxSize++;
            }

            if(k%2==0){
                ans[idx] = ((double)max.lastKey() + min.firstKey())/2;
            } else {
                ans[idx] = (double)max.lastKey();
            }

            idx++;
            l++;
            r++;
        }

        return ans ;
    }
}