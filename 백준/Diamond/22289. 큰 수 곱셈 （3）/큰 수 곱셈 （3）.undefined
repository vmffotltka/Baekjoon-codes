#include <bits/stdc++.h>
using namespace std;

const double PI = acos(-1);
typedef complex<double> cpx;

void fft(vector<cpx>& a, bool invert) {
    int n = a.size();
    for (int i = 1, j = 0; i < n; i++) {
        int bit = n >> 1;
        while (!((j ^= bit) & bit)) bit >>= 1;
        if (i < j) swap(a[i], a[j]);
    }
    for (int len = 2; len <= n; len <<= 1) {
        double ang = 2 * PI / len * (invert ? -1 : 1);
        cpx wlen(cos(ang), sin(ang));
        for (int i = 0; i < n; i += len) {
            cpx w(1);
            for (int j = 0; j < len / 2; j++) {
                cpx u = a[i + j], v = a[i + j + len / 2] * w;
                a[i + j] = u + v;
                a[i + j + len / 2] = u - v;
                w *= wlen;
            }
        }
    }
    if (invert) {
        for (int i = 0; i < n; i++) a[i] /= n;
    }
}

void multiply(const vector<int>& a, const vector<int>& b, vector<long long>& res) {
    vector<cpx> fa(a.begin(), a.end()), fb(b.begin(), b.end());
    int n = 1;
    while (n < a.size() + b.size()) n <<= 1;
    fa.resize(n); fb.resize(n);
    fft(fa, false); fft(fb, false);
    for (int i = 0; i < n; i++) fa[i] *= fb[i];
    fft(fa, true);
    res.resize(n);
    for (int i = 0; i < n; i++) res[i] = (long long)round(fa[i].real());
}


int main() {
    cin.tie(0)->sync_with_stdio(0);
    string a, b; cin >> a >> b;
    if (a == "0" || b == "0") {
        cout << 0;
        return 0;
    }
    vector<int> A, B;
    for (int i = a.size() - 1; i >= 0; i--) A.push_back(a[i] - '0');
    for (int i = b.size() - 1; i >= 0; i--) B.push_back(b[i] - '0');
    vector<long long> res;
    multiply(A, B, res);
    for (int i = 0; i < res.size(); i++) {
        if (res[i] >= 10) {
            if (i + 1 == res.size()) res.push_back(0);
            res[i + 1] += res[i] / 10;
            res[i] %= 10;
        }
    }
    int idx = res.size() - 1;
    while (idx > 0 && res[idx] == 0) idx--;
    for (int i = idx; i >= 0; i--)
        cout << res[i];
}