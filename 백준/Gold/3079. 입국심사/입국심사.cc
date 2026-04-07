#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll arr[100000];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    int n, m; cin >> n >> m;
    for (int i = 0; i < n; i++) cin >> arr[i];
    ll s = 0, e = 1e18, ans = 0;
    while (s <= e) {
		ll mid = (s + e) / 2;
        ll sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mid / arr[i];
			if (sum >= m) break;
        }
		if (sum >= m) {
            ans = mid;
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    cout << ans;
}