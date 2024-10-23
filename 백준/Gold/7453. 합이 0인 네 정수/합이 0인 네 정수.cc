#include <bits/stdc++.h>
using namespace std;

int N, A[4000], B[4000], C[4000], D[4000];
vector<int> S1, S2;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N;
    for (int i = 0; i < N; i++) {
        cin >> A[i] >> B[i] >> C[i] >> D[i];
    }
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            int p1 = A[i] + B[j], p2 = C[i] + D[j];
            S1.push_back(p1), S2.push_back(p2);
        }
    }
    sort(S1.begin(), S1.end());
    sort(S2.begin(), S2.end());
    long long ans = 0;
    for (int i = 0; i < N * N; i++) {
        int idx1 = lower_bound(S2.begin(), S2.end(), -S1[i]) - S2.begin();
        int idx2 = upper_bound(S2.begin(), S2.end(), -S1[i]) - S2.begin();
        if (S1[i] + S2[idx1] != 0) continue;
        ans += idx2 - idx1;
    }
    cout << ans;
}