#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; string s; cin >> n >> s;
    for (int i = 1; i < n; i++) {
        if (s[i] == 'J') cout << s[i - 1] << '\n';
    }
}