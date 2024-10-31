#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, preA = 0, preB = 0; cin >> n;
    for (int i = 0; i < n; i++) {
        int a, b; cin >> a >> b;
        if (preA > a || preB > b) {
            cout << "no";
            return 0;
        }
        preA = a, preB = b;
    }
    cout << "yes";
}