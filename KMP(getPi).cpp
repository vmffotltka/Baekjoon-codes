vector<int> getPi(string p) {
	int m = (int)p.size(), j = 0; //  m은 배열 크기, j는 접두사를 가리키는 변수
	vector<int> pi(m, 0);
	for (int i = 1; i < m; i++) { // i는 접미사를 가리키는 변수
		while (j > 0 && p[i] != p[j]) // j가 양수라는 것은 매칭된 것이 있다는 것. p[i] != p[j] 이므로 매칭에 실패함.
			j = pi[j - 1]; // 매칭된 문자열에서 max(접미사 = 접두사)인 위치로 돌아감
		if (p[i] == p[j]) // 매칭된 경우 
			pi[i] = ++j;
	}
	return pi;
}
