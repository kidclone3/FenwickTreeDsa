import java.util.Arrays;

public class FenwickTreeMin {
    int n; // size
    final int N = (int) 1e5+5;
    final int INF = Integer.MAX_VALUE;
    int bit[] = new int[N];
    FenwickTreeMin(int size) {
        n = size;
        Arrays.fill(bit, INF);
    }
    FenwickTreeMin(int[] a) {
        n = a.length;
        for(int i = 1; i <= n; ++i) {
            add(i, a[i]);
        }
    }
    void add(int u, int v) {
        for(int i = u; i < N; i += i & (-i)) {
            bit[i] = Math.min(bit[i], v);
        }
    }
    int getMin(int p) {
        int answer = INF;
        for(int i = p; i > 0; i -= i&(-i)) {
            answer = Math.min(bit[i], answer);
        }
        return answer;
    }
}
