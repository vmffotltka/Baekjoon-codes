#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int t, ans = 0; cin >> t; while (t--) {
        int p; cin >> p;
        if (p > 1) ans++;
    }
    cout << ans;
}