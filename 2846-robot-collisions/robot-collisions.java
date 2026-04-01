class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] hlth, String dirs) {
        List<Integer> ans = new ArrayList<>();
        int n = pos.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(pos[i], hlth[i], dirs.charAt(i), i);
        }
        Arrays.sort(arr, (a, b) -> a.pos - b.pos);
        Stack<Pair> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            Pair curr = arr[i];
            boolean hehe = true;

            while (!st.isEmpty() && st.peek().dir == 'R' && curr.dir == 'L') {
                if (st.peek().health == curr.health) {
                    st.pop();
                    hehe = false;
                    break;
                } 
                else if (st.peek().health < curr.health) {
                    st.pop();
                    curr.health--; 
                } 
                else {
                    Pair top = st.pop();
                    top.health--;
                    st.push(top);
                    hehe = false;
                    break;
                }
            }
            if (hehe) {
                st.push(curr);
            }
        }

        List<Pair> res = new ArrayList<>();
        while (!st.isEmpty()) res.add(st.pop());
        Collections.sort(res, (a, b) -> a.idx - b.idx);

        for (Pair p : res) ans.add(p.health);
        return ans;
    }

    class Pair {
        int pos;
        int health;
        char dir;
        int idx;

        public Pair(int pos, int health, char dir, int idx) {
            this.pos = pos;
            this.health = health;
            this.dir = dir;
            this.idx = idx;
        }
    }
}