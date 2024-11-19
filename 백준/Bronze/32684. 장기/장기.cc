#include <bits/stdc++.h>
using namespace std;

int score[6] = { 13, 7, 5, 3, 3, 2 };

int main() {
	cin.tie(0)->sync_with_stdio(0);
	int cho = 0, han = 3;
	for (int i = 0; i < 2; i++) {
		for (int j = 0; j < 6; j++) {
			int p; cin >> p;
			(i ? han : cho) += score[j] * 2 * p;
		}
	}
	cout << (han > cho ? "ekwoo" : "cocjr0208");
}