#include <bits/stdc++.h>
using namespace std;

int N, sqrtN, C, M, cnt[10001], arr[300000], ans[10000];
struct Query {
    int left, right, index;
    bool operator<(Query& other) const {
        return (left / sqrtN == other.left / sqrtN ? right < other.right : left / sqrtN < other.left / sqrtN);
    }
} query[10000];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> C;
    sqrtN = sqrt(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    cin >> M;
    for (int i = 0; i < M; i++) {
        int left, right; cin >> left >> right;
        query[i] = { left - 1, right - 1, i };
    }
    sort(query, query + M);
    int left = query[0].left, right = query[0].right, hat = -1;
    for (int i = left; i <= right; i++) ++cnt[arr[i]];
    for (int i = 1; i <= C; i++)
        if (right - left + 1 < cnt[i] * 2) { hat = i; break; }
    ans[query[0].index] = hat;
    for (int i = 1; i < M; i++) {
        hat = -1;
        auto& [curLeft, curRight, curIndex] = query[i];
        while (curLeft < left) ++cnt[arr[--left]];
        while (right < curRight) ++cnt[arr[++right]];
        while (left < curLeft) --cnt[arr[left++]];
        while (curRight < right) --cnt[arr[right--]];
        for (int j = 1; j <= C; j++)
            if (right - left + 1 < cnt[j] * 2) { hat = j; break; }
        ans[curIndex] = hat;
    }
    for (int i = 0; i < M; i++) {
        if (ans[i] == -1) cout << "no\n";
        else {
            cout << "yes " << ans[i] << '\n';
        }
    }
}