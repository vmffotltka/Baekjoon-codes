#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t; cin >> t; while (t--) {
        int l, r, n, m; cin >> l >> r >> n >> m;
        if (n == m) cout << "G\n";
        else {
            int dist = abs(n - m);
            if (dist <= l && dist <= r) cout << "E\n";
            else if (dist <= l) cout << "L\n";
            else cout << "R\n";
        }
    }
}