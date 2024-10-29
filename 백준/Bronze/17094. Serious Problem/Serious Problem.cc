#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, cnt = 0; string s;
    cin >> n >> s;
    for (auto i : s) {
        if (i == '2') cnt++;
    }
    cout << (cnt * 2 == n ? "yee" : (cnt * 2 > n ? "2" : "e"));
}