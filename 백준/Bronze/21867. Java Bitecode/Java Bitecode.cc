#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; string s; cin >> n >> s;
    bool tri = false;
    for (int i = 0; i < n; i++) {
        if (s[i] == 'J' || s[i] == 'A' || s[i] == 'V') continue;
        tri = true;
        cout << s[i];
    }
    if (!tri) cout << "nojava";
}