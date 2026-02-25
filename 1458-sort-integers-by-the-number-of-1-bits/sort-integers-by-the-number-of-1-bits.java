class Solution {
    public int[] sortByBits(int[] arr) {
        List<Integer> list = new ArrayList<>() ;
        for(int i : arr)list.add(i) ;
        Collections.sort(list, (a, b) -> {
            int ca = Integer.bitCount(a);
            int cb = Integer.bitCount(b);

            if (ca != cb) {
                return ca - cb ;  
            }
            return a - b;
        });
        return list.stream().mapToInt(i -> i).toArray() ;
    }
}