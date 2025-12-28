class Solution {
    public String minimizeStringValue(String s) {
        StringBuilder a = new StringBuilder(s);
        List<Integer> b = new ArrayList<>();
        Map<Character, Integer> c = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char d = s.charAt(i);
            if (d != '?') {
                c.put(d, c.getOrDefault(d, 0) + 1);
            } else {
                b.add(i);
            }
        }

        List<Character> e = new ArrayList<>();
        for (int i = 0; i < b.size(); i++) {
            char f = 'a';
            int g = Integer.MAX_VALUE;

            for (char h = 'a'; h <= 'z'; h++) {
                int j = c.getOrDefault(h, 0);
                if (j < g) {
                    g = j;
                    f = h;
                }
            }

            e.add(f);
            c.put(f, c.getOrDefault(f, 0) + 1);
        }
        Collections.sort(e);

        for (int i = 0; i < b.size(); i++) {
            a.setCharAt(b.get(i), e.get(i));
        }
        return a.toString();
    }
}
