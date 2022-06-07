public class FenwickTreePointQueries {
    int n; // size
    final int N = (int) 1e5 + 5;
    int bit[] = new int[N];

    FenwickTreePointQueries() {
    }

    FenwickTreePointQueries(int size) {
        n = size;
    }

    FenwickTreePointQueries(int[] a) {
        n = a.length;
        for (int i = 1; i < n; ++i) {
            bit[i] += a[i];
            int j = i + (i & (-i));
            if (j < n) {
                bit[j] += bit[i];
            }
        }
    }

    void updatePoint(int u, int v) {
        for(int i = u; i < n; i += i & -i) {
            bit[i] += v;
        }
    }

    void updateRange(int l, int r, int v) {
        updatePoint(l, v);
        updatePoint(r + 1, -v);
    }

    int get(int p) {
        int ans = 0;
        for(int i = p; i > 0; i -= i & -i) {
            ans += bit[i];
        }
        return ans;
    }
}
