import java.io.File;
import java.io.FileNotFoundException;

public class SegmentTree {
   final int N = (int) 1e5 + 5;  // limit for array size
    int n;  // array size
    int[] t = new int[2 * N];

    void build() {  // build the tree
        for (int i = n - 1; i > 0; --i) t[i] = t[i<<1] + t[i<<1|1];
    }

    void modify(int p, int value) {  // set value at position p
        for (t[p += n] = value; p > 1; p >>= 1) t[p>>1] = t[p] + t[p^1];
    }

    int query(int l, int r) {  // sum on interval [l, r)
        int res = 0;
        for (l += n, r += n; l < r; l >>= 1, r >>= 1) {
            if ((l&1) != 0) res += t[l++];
            if ((r&1) != 0) res += t[--r];
        }
        return res;
    }

    public void main() throws FileNotFoundException {
        MyScanner sc = new MyScanner("src/input.txt");
        n = sc.nextInt();
        for (int i = 0; i < n; ++i) t[n+i] = sc.nextInt();
        build();
//        modify(0, 1);
        int q = sc.nextInt();
        for (int i = 0; i < q; ++i) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();
//            System.out.println(query(l-1, r));
            query(l-1, r);
        }
    }
}
