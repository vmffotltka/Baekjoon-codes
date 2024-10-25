#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int a, b, c; cin >> a >> b >> c;
    int score = 0, days = 0;
    while (true) {
        if (score >= c) break;
        score += (days % 7 == 6 ? a + b : a);
        days++;
    }
    cout << days;
}