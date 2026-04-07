#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    string l, r; cin >> l >> r;
    if (l.size() != r.size())
        cout << 0;
    else {
        int cnt = 0;
        for (int i = 0; i < l.size(); i++) {
            if (l[i] == r[i] && l[i] == '8')
                cnt++;
			else if (l[i] != r[i])
                break;
        }
        cout << cnt;
    }
}