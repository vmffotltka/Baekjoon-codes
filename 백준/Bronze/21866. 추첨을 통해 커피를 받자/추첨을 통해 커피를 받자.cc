#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int sum = 0;
    for (int i = 0; i < 9; i++) {
        int limit = (i + 2) / 2 * 100;
        int score; cin >> score;
        if (score > limit) { cout << "hacker"; return 0; }
        sum += score;
    }
    cout << (sum >= 100 ? "draw" : "none");
}