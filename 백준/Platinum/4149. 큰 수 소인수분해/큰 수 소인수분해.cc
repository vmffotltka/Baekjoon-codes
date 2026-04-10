#include <bits/stdc++.h>
using namespace std;

using ull = unsigned long long;

ull mul(ull a, ull b, ull mod) {
    ull res = 0;
	a %= mod;
    while (b > 0) {
		if (b & 1) res = (res + a) % mod;
        a = (a * 2) % mod;
        b >>= 1;
    }
	return res;
}

ull power(ull base, ull exp, ull mod) {
    ull res = 1;
	base %= mod;
    while (exp > 0) {
		if (exp & 1) res = mul(res, base, mod);
		base = mul(base, base, mod);
        exp >>= 1;
    }
    return res;
}

bool miller_rabin(ull n, ull a) {
    if (n % a == 0) return false;
    ull k = n - 1;
    while (true) {
		ull temp = power(a, k, n);
        if (temp == n - 1) return true;
		if (k % 2 == 1) return temp == 1 || temp == n - 1;
        k /= 2;
    }
}

bool is_prime(ull n) {
    if (n <= 1) return false;
	if (n <= 3) return true;
	if (n % 2 == 0) return false;
    ull bases[] = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37 };
    for (ull a : bases) {
        if (a == n) return true;
        if (!miller_rabin(n, a)) return false;
	}
    return true;
}

ull gcd(ull a, ull b) {
    while (b) {
        ull temp = a % b;
        a = b;
        b = temp;
    }
    return a;
}

ull pollard_rho(ull n) {
    if (n % 2 == 0) return 2;
	if (is_prime(n)) return n;
    
    ull x = rand() % (n - 2) + 2;
    ull y = x;
    ull c = rand() % 10 + 1;
    ull g = 1;

    auto f = [&](ull x) {
		return (mul(x, x, n) + c) % n;
	};
    while (g == 1) {
        x = f(x);
		y = f(f(y));
        ull diff = x > y ? x - y : y - x;
		g = gcd(diff, n);
        if (g == n) {
            x = rand() % (n - 2) + 2;
            y = x;
            c = rand() % 10 + 1;
			g = 1;
        }
    }
    return g;
}

vector<ull> factors;

void factorize(ull n) {
    if (n == 1) return;
    if (is_prime(n)) {
        factors.push_back(n);
		return;
    }
	ull d = pollard_rho(n);
    factorize(d);
    factorize(n / d);
}

int main() {
    cin.tie(0)->sync_with_stdio(0);
    srand(1998);
    ull N; cin >> N;
    factorize(N);
	sort(factors.begin(), factors.end());
	for (ull f : factors) cout << f << '\n';
}