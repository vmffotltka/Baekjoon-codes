#include <bits/stdc++.h>
using namespace std;

int N, sqrtN, K, M, arr[100000], ans[100000], groups[320], leaves[320][320];
deque<int> indexes[100001];
struct Query {
    int left, right, index;
    bool operator<(Query& other) const {
        return (left / sqrtN == other.left / sqrtN ? right < other.right : left / sqrtN < other.left / sqrtN);
    }
} query[100000];

int main() {
    cin.tie(0)->sync_with_stdio(0);
    cin >> N >> K;
    sqrtN = sqrt(N);
    for (int i = 0; i < N; i++) cin >> arr[i];
    cin >> M;
    for (int i = 0; i < M; i++) {
        int left, right; cin >> left >> right;
        query[i] = { left - 1, right - 1, i };
    }
    sort(query, query + M);
    auto &[left, right, index] = query[0];
    for (int i = left; i <= right; i++) {
        if (!indexes[arr[i]].empty()) {
            int pre = indexes[arr[i]].back() - indexes[arr[i]].front();
            groups[pre / sqrtN]--, leaves[pre / sqrtN][pre % sqrtN]--;
        }
        indexes[arr[i]].push_back(i);
        int dif = indexes[arr[i]].back() - indexes[arr[i]].front();
        groups[dif / sqrtN]++, leaves[dif / sqrtN][dif % sqrtN]++;
    }
    for (int i = sqrtN + 2; i >= 0; i--) {
        if (groups[i]) {
            for (int j = sqrtN + 2; j >= 0; j--) {
                if (leaves[i][j]) {
                    ans[index] = i * sqrtN + j;
                    break;
                }
            }
            break;
        }
    }
    for (int i = 1; i < M; i++) {
        int pre, cur;
        auto& [curLeft, curRight, curIndex] = query[i];
        while (curLeft < left) {
            left--;
            if (!indexes[arr[left]].empty()) {
                pre = indexes[arr[left]].back() - indexes[arr[left]].front();
                groups[pre / sqrtN]--, leaves[pre / sqrtN][pre % sqrtN]--;
            }
            indexes[arr[left]].push_front(left);
            cur = indexes[arr[left]].back() - indexes[arr[left]].front();
            groups[cur / sqrtN]++, leaves[cur / sqrtN][cur % sqrtN]++;
        }
        while (right < curRight) {
            right++;
            if (!indexes[arr[right]].empty()) {
                pre = indexes[arr[right]].back() - indexes[arr[right]].front();
                groups[pre / sqrtN]--, leaves[pre / sqrtN][pre % sqrtN]--;
            }
            indexes[arr[right]].push_back(right);
            cur = indexes[arr[right]].back() - indexes[arr[right]].front();
            groups[cur / sqrtN]++, leaves[cur / sqrtN][cur % sqrtN]++;
        }
        while (left < curLeft) {
            pre = indexes[arr[left]].back() - indexes[arr[left]].front();
            groups[pre / sqrtN]--, leaves[pre / sqrtN][pre % sqrtN]--;
            indexes[arr[left]].pop_front();
            if (!indexes[arr[left]].empty()) {
                cur = indexes[arr[left]].back() - indexes[arr[left]].front();
                groups[cur / sqrtN]++, leaves[cur / sqrtN][cur % sqrtN]++;
            }
            left++;
        }
        while (curRight < right) {
            pre = indexes[arr[right]].back() - indexes[arr[right]].front();
            groups[pre / sqrtN]--, leaves[pre / sqrtN][pre % sqrtN]--;
            indexes[arr[right]].pop_back();
            if (!indexes[arr[right]].empty()) {
                cur = indexes[arr[right]].back() - indexes[arr[right]].front();
                groups[cur / sqrtN]++, leaves[cur / sqrtN][cur % sqrtN]++;
            }
            right--;
        }
        for (int j = sqrtN + 2; j >= 0; j--) {
            if (groups[j]) {
                for (int k = sqrtN + 2; k >= 0; k--) {
                    if (leaves[j][k]) {
                        ans[curIndex] = j * sqrtN + k;
                        break;
                    }
                }
                break;
            }
        }
    }
    for (int i = 0; i < M; i++)
        cout << ans[i] << '\n';
}