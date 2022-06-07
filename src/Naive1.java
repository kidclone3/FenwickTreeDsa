public class Naive1 {
    final int N = 100005;
    int a[] = new int[N];
    void update(int u, int v) {
        a[u] += v;
    }
    int getSum(int p) {
        int answer = 0;
        for (int i = 1; i <= p; ++i) {
            answer += a[i];
        }
        return answer;
    }
}
