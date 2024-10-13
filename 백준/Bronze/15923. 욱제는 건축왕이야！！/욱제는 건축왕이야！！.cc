#include <bits/stdc++.h>
using namespace std;

int X[20], Y[20];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    for (int i = 0; i < n; i++) cin >> X[i] >> Y[i];
    int ans = (X[0] == X[n - 1] ? abs(Y[0] - Y[n - 1]) : abs(X[0] - X[n - 1]));
    for (int i = 1; i < n; i++)
        ans += (X[i - 1] == X[i] ? abs(Y[i] - Y[i - 1]) : abs(X[i] - X[i - 1]));
    cout << ans;
}