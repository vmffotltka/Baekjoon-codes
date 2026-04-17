#include <bits/stdc++.h>
using namespace std;

struct PosChar {
    int v, x, f_tx;
};

struct NegChar {
	int v, x, b_tx;
};

int main() {
    cin.tie(0)->sync_with_stdio(0);
    string t; cin >> t;
	vector<PosChar> pos_chars;
	vector<NegChar> neg_chars;
	int b = 0, f = 0;
	bool rev = false;
	for (char c : t) {
		if (c == '-')
			rev = !rev;
		else {
			int v = c - '0';
			if (!rev) {
				pos_chars.push_back({ v, b, f });
				b++;
			}
			else {
				f++;
				neg_chars.push_back({ v, -f, b });
			}
		}
	}

	int b_final = b, f_final = f, mxlen = b_final + f_final;
	vector<long long> diff(mxlen + 25, 0);
	auto add_range = [&](int start, int end, int v) {
		if (start <= end) {
			diff[start] += v;
			diff[end + 1] -= v;
		}
	};
	for (auto& pc : pos_chars) {
		int v = pc.v, x = pc.x, f_tx = pc.f_tx;
		add_range(0, b_final - 1 - x, v);
		add_range(x + f_tx + 1, x + f_final, v);
	}
	for (auto& nc : neg_chars) {
		int v = nc.v, x = nc.x, b_tx = nc.b_tx;
		add_range(b_tx - x, b_final - 1 - x, v);
		add_range(0, x + f_final, v);
	}
	vector<long long> ans(mxlen + 25, 0);
	long long current = 0;
	for (int p = 0; p < ans.size(); p++) {
		current += diff[p];
		ans[p] = current;
	}
	long long carry = 0;
	for (int p = 0; p < ans.size(); p++) {
		long long total = ans[p] + carry;
		ans[p] = total % 10;
		carry = total / 10;
	}

	int highest = ans.size() - 1;
	while (highest > 0 && ans[highest] == 0)
		highest--;

	string res = "";
	for (int p = highest; p >= 0; p--)
		res += char(ans[p] + '0');
	cout << res;
}