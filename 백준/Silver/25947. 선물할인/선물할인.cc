#include <bits/stdc++.h>
using namespace std;
using ll = long long;

ll N, B, A, arr[100000];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> B >> A;
    for (int i = 0; i < N; i++) cin >> arr[i];
    sort(arr, arr + N);
    ll sum = 0;
    for (int i = 0; i < N; i++) {
        if (i < A)
            sum += arr[i] / 2;
        else
            sum += (arr[i - A] + arr[i]) / 2;
        if (B < sum) {
            cout << i; return 0;
        }
    }
    cout << N;
}