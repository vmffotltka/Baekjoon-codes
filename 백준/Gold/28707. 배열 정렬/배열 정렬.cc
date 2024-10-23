#include <bits/stdc++.h>
using namespace std;

int N, M;
map<string, int> dist;
string start, goal;
struct Query {
    int l, r, w;
} query[10];

void dijk() {
    priority_queue<pair<int, string>> pq;
    pq.push({ 0, start });
    while (!pq.empty()) {
        auto [w, cur] = pq.top(); pq.pop();
        if (dist[cur] < -w) continue;
        dist[cur] = -w;
        for (int i = 0; i < M; i++) {
            auto &[i1, i2, cost] = query[i];
            string next = cur;
            swap(next[i1], next[i2]);
            if (!dist[next] || dist[next] > -w + cost) {
                dist[next] = -w + cost;
                pq.push({ -dist[next], next});
            }
        }
    }
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        int p; cin >> p;
        start += p + '0' - 1;
    }
    goal = start;
    sort(goal.begin(), goal.end());
    cin >> M;
    for (int i = 0; i < M; i++) {
        int l, r, w; cin >> l >> r >> w;
        query[i] = { --l, --r, w };
    }
    if (start == goal) {
        cout << 0;
        return 0;
    }
    dijk();
    cout << (dist[goal] ? dist[goal] : -1);
}