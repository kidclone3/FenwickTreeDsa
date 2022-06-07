public class FenwickTreeRangeQueries {
    int n; // size
    final int N = (int) 1e5 + 5;
    int bit[] = new int[N];
    int bit1[] = new int[N];
    int bit2[] = new int[N];

    FenwickTreeRangeQueries() {
    }

    FenwickTreeRangeQueries(int size) {
        n = size;
    }

    FenwickTreeRangeQueries(int[] a) {
        n = a.length;
        for (int i = 1; i < n; ++i) {
            bit[i] += a[i];
            int j = i + (i & (-i));
            if (j < n) {
                bit[j] += bit[i];
            }
        }
    }

    void updatePoint(int[] b, int u, int v) {
        for (int i = u; i < n; i += i & -i) {
            b[i] += v;
        }
    }

    void updateRange(int l, int r, int v) {
        updatePoint(bit1, l, (n - l + 1) * v);
        updatePoint(bit1, r + 1, -(n - r) * v);
        updatePoint(bit2, l, v);
        updatePoint(bit2, r + 1, -v);
    }

    int getSumOnBIT(int[] b, int p) {
        int ans = 0;
        for (int i = p; i > 0; i -= i & -i) {
            ans += bit[i];
        }
        return ans;
    }

    int prefixSum(int u) {
        return getSumOnBIT(bit1, u) - getSumOnBIT(bit2, u) * (n - u);
    }

    int rangeSum(int l, int r) {
        return prefixSum(r) - prefixSum(l - 1);
    }
}
