#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, M, ans = -1, salary[100001], leadership[100001];
vector<ll> edge[100001];
priority_queue<ll> pq[100001];

ll dfs(ll node) {
    pq[node].push(salary[node]);
    ll ret = salary[node];
    for (auto& next : edge[node]) {
        ret += dfs(next);
        if (pq[node].size() < pq[next].size()) swap(pq[node], pq[next]);
        while (!pq[next].empty()) {
            pq[node].push(pq[next].top());
            pq[next].pop();
        }
        while (ret > M) {
            ret -= pq[node].top();
            pq[node].pop();
        }
    }
    ans = max(ans, static_cast<ll>(pq[node].size()) * leadership[node]);
    return ret;
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> M;
    ll start = 0;
    for (int i = 1; i <= N; i++) {
        ll boss; cin >> boss;
        if (!boss) start = i;
        else edge[boss].push_back(i);
        cin >> salary[i] >> leadership[i];
    }
    dfs(start);
    cout << ans;
}