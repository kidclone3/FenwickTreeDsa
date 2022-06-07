public class Naive2 {
    final int N = (int)1e5+5;
    int n; // size of a, n < N
    int a[] = new int[N];
    int sum[] = new int[N];
    void preProcess() {
        sum[1] = a[1];
        for(int i = 2; i <= n; ++i) {
            sum[i] = sum[i-1] + a[i];
        }
    }
    void update(int u, int v) {
        for(int i = u; i <= n; ++i) {
            sum[i] += v;
        }
    }
    int getSum(int p) {
        return sum[p];
    }
}
