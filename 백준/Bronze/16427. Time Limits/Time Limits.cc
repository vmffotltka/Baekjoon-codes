#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, s, mx = -1; cin >> n >> s;
    for (int i = 0; i < n; i++) {
        int p; cin >> p;
        mx = max(mx, p);
    }
    cout << (mx * s + 999) / 1000;
}