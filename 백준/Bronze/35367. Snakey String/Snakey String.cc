#include <bits/stdc++.h>
using namespace std;

string arr[100];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, m; cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    string ans = "";
    for (int j = 0; j < m; j++) {
        for (int i = 0; i < n; i++) {
            if (arr[i][j] == '.') continue;
            ans += arr[i][j];
            break;
        }
    }
    cout << ans;
}