#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cout.precision(2); cout << fixed;
    int i = 1;
    while (true) {
        int n; cin >> n;
        if (!n) break;
        double profit = 0, cost = 0;
        for (int i = 0; i < n; i++) {
            double a, b, c, d; cin >> a >> b >> c >> d;
            profit += a * 0.8 + b + c * 1.2 + d * 0.8;
            cost += a / 85 * 15.5 + b / 85 * 32 + c / 85 * 40 + d * 0.2;
        }
        cout << "Case #" << i++ << ": RM" << profit - cost << '\n';
    }
}