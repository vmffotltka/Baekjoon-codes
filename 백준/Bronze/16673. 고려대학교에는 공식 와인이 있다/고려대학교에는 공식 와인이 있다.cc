#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int c, k, p; cin >> c >> k >> p;
    cout << k * c * (c + 1) / 2 + p * c * (2 * c + 1) * (c + 1) / 6;
}