#include <bits/stdc++.h>
using namespace std;

int N;
int trans[2][12];
int can_reach[2][4096];

bool is_zero_reachable() {
    vector<bool> vis(4096, false);
    queue<int> q;

    q.push(1);
    vis[1] = true;

    while (!q.empty()) {
        int curr = q.front();
        q.pop();
		int nxt_r = 0, nxt_b = 0;
        for (int v = 0; v < N; v++) {
            if (curr & (1 << v)) {
                nxt_r |= trans[0][v];
                nxt_b |= trans[1][v];
            }
        }
        if (nxt_r == 0 || nxt_b == 0) return true;

        if (!vis[nxt_r]) {
            vis[nxt_r] = true;
            q.push(nxt_r);
        }
        if (!vis[nxt_b]) {
            vis[nxt_b] = true;
            q.push(nxt_b);
        }
    }
    return false;
}

bool check(int k) {
    int num_states = 1 << k;
    vector<int> S(num_states, (1 << N) - 1);
	int mask_k_1 = (1 << (k - 1)) - 1;

    bool changed = true;
    while (changed) {
        changed = false;
        for (int w = 0; w < num_states; w++) {
            int c = w >> (k - 1);
            int base_w = (w & mask_k_1) << 1;

			int valid_u = S[base_w | 0] & S[base_w | 1];

			int next_Sw = S[w] & can_reach[c][valid_u];
            if (S[w] != next_Sw) {
                S[w] = next_Sw;
                changed = true;
            }
        }
        for (int w = 0; w < num_states; w++) {
            if ((S[w] & 1) == 0) return false;
        }
    }
    return true;
}

void solve() {
    cin >> N;
    for (int c = 0; c < 2; c++) {
        for (int i = 0; i < N; i++) {
            trans[c][i] = 0;
            for (int j = 0; j < N; j++) {
                int x; cin >> x;
				if (x == 1) trans[c][i] |= (1 << j);
            }
        }
    }
    for (int c = 0; c < 2; c++) {
        for (int mask = 0; mask < (1 << N); mask++) {
            int can = 0;
            for (int v = 0; v < N; v++) {
				if (trans[c][v] & mask) can |= (1 << v);
            }
			can_reach[c][mask] = can;
        }
    }
    if (is_zero_reachable()) {
		cout << "0\n";
        return;
    }
    for (int k = 1; k <= 23; k++) {
        if (check(k)) {
            cout << k << '\n';
            return;
        }
    }
    cout << "0\n";
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t; cin >> t;
    while (t--) solve();
}