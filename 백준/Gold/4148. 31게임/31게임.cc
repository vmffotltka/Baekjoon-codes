#include <bits/stdc++.h>
using namespace std;

int main() {
    cin.tie(0)->sync_with_stdio(0);
    string s;
    while (cin >> s) {
        int turn = 0, sum = 0;
        vector<int> cnt(7, 4);
        for (auto i : s) {
            sum += i - '0';
            if (sum > 31) break;
            cnt[i - '0']--;
            turn ^= 1;
        }
        while (sum < 31) {
            int next = sum + ((sum % 7 < 3 ? 3 : 10) - sum % 7);
            int dif = next - sum;
            if (dif != 7 && cnt[dif]) {
                sum = next;
                cnt[dif]--;
            }
            else {
                int mn = INT_MAX;
                for (int i = 1; i < 7; i++) {
                    if (!cnt[i]) continue;
                    if (cnt[i] && !cnt[7 - i]) {
                        next = sum + i;
                        dif = i;
                        break;
                    }
                    else {
                        if (mn > cnt[i]) {
                            mn = cnt[i];
                            next = sum + i;
                            dif = i;
                        }
                    }
                }
                sum = next;
                cnt[dif]--;
            }
            if (sum > 31) break;
            turn ^= 1;
        }
        cout << s << " " << (turn ? "A" : "B") << '\n';
    }
}