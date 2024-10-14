#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n; cin >> n;
    for (int i = 1; i <= n; i++) {
        string s; cin >> s;
        if (s == "mumble") continue;
        if (stoi(s) != i) {
            cout << "something is fishy";
            return 0;
        }
    }
    cout << "makes sense";
}