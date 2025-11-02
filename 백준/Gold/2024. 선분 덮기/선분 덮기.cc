#include <bits/stdc++.h>
using namespace std;

int M, Dist[50001];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> M;
    while (true) {
        int l, r; cin >> l >> r;
        if (!l && !r) break;
        l = max(0, l), r = min(M, r);
        if (l >= M || r <= 0 || l == r) continue;
        Dist[l] = max(Dist[l], r);
    }
    for (int i = 1; i <= M; i++)
        Dist[i] = max(Dist[i], Dist[i - 1]);
    int start = 0, cnt = 0;
    while (true) {
        int next = Dist[start];
        if (next == start)
            break;
        start = next;
        cnt++;
    }
    cout << (start == M ? cnt : 0);
}