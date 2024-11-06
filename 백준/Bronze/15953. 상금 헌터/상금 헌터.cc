#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int prize1[6] = { 500, 300, 200, 50, 30, 10 };
    int prize2[5] = { 512, 256, 128, 64, 32 };
    int t; cin >> t; while (t--) {
        int a, b, sum = 0; cin >> a >> b;
        if (a) {
            for (int i = 0; i < 6; i++) {
                a -= i + 1;
                if (a <= 0) { sum += prize1[i]; break; };
            }
        }
        if (b) {
            for (int i = 0; i < 5; i++) {
                b -= (1 << i);
                if (b <= 0) { sum += prize2[i]; break; }
            }
        }
        cout << sum * 10000 << '\n';
    }
}