#include <bits/stdc++.h>
using namespace std;

string one[10] = { "","I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
string ten[10] = { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
// I, V, X, L, C

int main() {
    cin.tie(0)->sync_with_stdio(0);
    string s; cin >> s;
    for (int i = 1; i < 100; i++) {
        string rome = ten[i / 10] + one[i % 10];
        string cnt1(5, '0'), cnt2(5, '0');
        for (auto i : s) {
            if (i == 'I') cnt1[0]++;
            if (i == 'V') cnt1[1]++;
            if (i == 'X') cnt1[2]++;
            if (i == 'L') cnt1[3]++;
            if (i == 'C') cnt1[4]++;
        }
        for (auto i : rome) {
            if (i == 'I') cnt2[0]++;
            if (i == 'V') cnt2[1]++;
            if (i == 'X') cnt2[2]++;
            if (i == 'L') cnt2[3]++;
            if (i == 'C') cnt2[4]++;
        }
        if (cnt1 == cnt2) { cout << rome; return 0; }
    }
}