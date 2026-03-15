import java.util.*;

class Fancy {
    static int mod = 1_000_000_007;
    static List<Long> l;

    long mul = 1;
    long add = 0;

    public Fancy() {
        l = new ArrayList<>();
    }
    
    public void append(int val) {
        long v = (val - add + mod) % mod;
        v = (v * modInverse(mul)) % mod;
        l.add(v);
    }
    
    public void addAll(int inc) {
        add = (add + inc) % mod;
    }
    
    public void multAll(int m) {
        mul = (mul * m) % mod;
        add = (add * m) % mod;
    }
    
    public int getIndex(int idx) {
        if(idx >= l.size()) return -1;
        long val = (l.get(idx) * mul + add) % mod;
        return (int) val;
    }

    long modInverse(long x){
        return pow(x, mod - 2);
    }

    long pow(long a, long b){
        long res = 1;
        a %= mod;
        while(b > 0){
            if((b & 1) == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            b >>= 1;
        }
        return res;
    }
}