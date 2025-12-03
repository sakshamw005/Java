class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < arr2.length; j++) {
            int val = arr2[j];
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == val) {
                    ans.add(val);
                    arr1[i] = -1; 
                }
            }
        }

        Arrays.sort(arr1); 
        for (int x : arr1) {
            if (x != -1) ans.add(x); 
        }

        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) res[i] = ans.get(i);
        return res;
    }
}