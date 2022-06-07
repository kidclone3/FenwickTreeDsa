import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FenwickTree {
    int n; // size
    final int N = (int) 1e5+5;
    int bit[] = new int[N];
    FenwickTree() {}

    FenwickTree(int size) {
        n = size;
    }
    FenwickTree(int[] a) {
        n = a.length;
        for(int i = 1; i < n; ++i) {
            bit[i] += a[i];
            int j = i + (i&(-i));
            if (j < n) {
                bit[j] += bit[i];
            }
        }
    }
    void add(int u, int v) {
        for(int i = u; i < n; i += i & (-i)) {
            bit[i] += v;
        }
    }
    int getSum(int p) {
        int answer = 0;
        for(int i = p; i > 0; i -= i&(-i)) {
            answer += bit[i];
        }
        return answer;
    }

    int getSum(int l, int r) {
        return getSum(r) - getSum(l-1);
    }
    public void main() throws FileNotFoundException {
        MyScanner sc = new MyScanner("src/input2.txt");
        n = sc.nextInt() + 1;
        for (int i = 1; i < n; ++i) {
            int x = sc.nextInt();
            add(i, x);
        }
        int q = sc.nextInt();
        for (int i = 0; i < q; ++i) {
            int l, r;
            l = sc.nextInt();
            r = sc.nextInt();
//            System.out.println(getSum(l, r));
            getSum(l, r);
        }
    }
}
