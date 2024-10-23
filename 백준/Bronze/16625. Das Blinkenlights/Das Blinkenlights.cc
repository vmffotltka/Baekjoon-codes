#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int p, q, s; cin >> p >> q >> s;
    cout << (lcm(p, q) > s ? "no" : "yes");
}