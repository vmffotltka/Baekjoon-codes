#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    double k, d1, d2; cin >> k >> d1 >> d2;
    double a = (d1 - d2) / 2.0;
    cout.precision(7); cout << fixed;
    cout << k * k - a * a;
}