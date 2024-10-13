#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int kunas, n; cin >> kunas >> n;
    for (int i = 1; i < n; i++) {
        cout << i << '\n';
        kunas -= i;
    }
    cout << kunas;
}