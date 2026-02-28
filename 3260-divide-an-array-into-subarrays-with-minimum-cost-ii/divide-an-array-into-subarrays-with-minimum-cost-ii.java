class Solution {
    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        PriorityQueue<Integer> lp = new PriorityQueue<>((a, b)->b-a);
        PriorityQueue<Integer> rp = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();
        int vl = 0;
        long sl = 0;
        long res = Long.MAX_VALUE;

        for(int i=1; i<n; i++){
            
            if(i>=dist+2){
                int v = nums[i-dist-1];  
                if(v<lp.peek()){
                    map.merge(v, 1, Integer::sum);
                    vl--;
                    sl -= v;
                }
                else if(v==lp.peek()){
                    lp.poll();
                    vl--;
                    sl -= v;
                }
                else if(v==rp.peek()){
                    rp.poll();
                }
                else{
                    map.merge(v, 1, Integer::sum);
                }
            }


            if(i<=k-1 || nums[i]<=lp.peek()){
                lp.offer(nums[i]);
                vl++;
                sl += nums[i];
            }
            else{
                rp.offer(nums[i]);
            }

            if(i>k-1){
                if(vl<k-1){
                    int v = rp.poll();
                    lp.offer(v);
                    vl++;
                    sl += v;
                }
                else if(vl>k-1){
                    int v = lp.poll();
                    vl--;
                    sl -= v;
                    rp.offer(v);
                }
            }


            while(!lp.isEmpty() && map.getOrDefault(lp.peek(), 0)>0){
                int v = lp.poll();
                map.merge(v, -1, Integer::sum);
            }
            while(!rp.isEmpty() && map.getOrDefault(rp.peek(), 0)>0){
                int v = rp.poll();
                map.merge(v, -1, Integer::sum);
            }

            if(i>=dist+1){
                res = Math.min(res, sl);
            }
        }
        return res+nums[0];
    }
}