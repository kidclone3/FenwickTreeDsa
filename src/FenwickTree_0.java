public class FenwickTree_0 {
    int n; // size
    final int N = (int) 1e5+5;
    int bit[] = new int[N];
    FenwickTree_0(int size) {
        n = size;
    }
    FenwickTree_0(int[] a) {
        n = a.length;
        for(int i = 0; i < n; ++i) {
            add(i, a[i]);
        }
    }
    void add(int u, int v) {
        for(int i = u; i < n; i = i | (i + 1)) {
            bit[i] += v;
        }
    }
    int getSum(int p) {
        int answer = 0;
        for(int i = p; i >= 0; i = (i & (i+1)) - 1) {
            answer += bit[i];
        }
        return answer;
    }
}
