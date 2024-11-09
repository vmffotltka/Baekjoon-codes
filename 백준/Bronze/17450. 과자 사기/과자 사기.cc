#include <bits/stdc++.h>
using namespace std;

int main() {
	int idx = 0; double mx = -INFINITY;
	for (int i = 0; i < 3; i++) {
		double cost, wei; cin >> cost >> wei;
		double gsb = wei * 10 / (cost * 10 >= 5000 ? cost * 10 - 500 : cost * 10);
		if (mx < gsb) {
			mx = gsb;
			idx = i;
		}
	}
	cout << (idx == 0 ? "S" : (idx == 1 ? "N" : "U"));
}