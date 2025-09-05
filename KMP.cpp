vector<int> getPi(string p) { // 실패함수: 문자열 일치 여부를 검사하다가, 불일치가 발생하면 어떤 조치를 취해야 하는지에 대한 함수
	int m = (int)p.size(), j = 0; //  m은 배열 크기, j는 접두사를 가리키는 변수
	vector<int> pi(m, 0);
	for (int i = 1; i < m; i++) { // i는 접미사를 가리키는 변수
		while (j > 0 && p[i] != p[j]) // j가 양수라는 것은 매칭된 것이 있다는 것. p[i] != p[j] 이므로 매칭에 실패함.
			j = pi[j - 1]; // 매칭된 문자열에서 max(접미사 = 접두사)인 위치로 돌아감 (pi[j]는 할당된 값이 없음.)
		if (p[i] == p[j]) // 매칭된 경우 
			pi[i] = ++j;
	}
	return pi;
}

vector<int> kmp(string s, string p) { // s 문자열에서 p 문자열 검색
	vector<int> ans;
	auto pi = getPi(p); // 검색하는 문자열의 pi배열 생성
	int n = (int)s.size(), m = (int)p.size(), j = 0; // j는 p문자열의 앞을 가리킴
	for (int i = 0; i < n; i++) { // i는 s문자열의 앞을 가리킴
		while (j > 0 && s[i] != p[j]) // 문자열이 매칭된 게 있는데 현재 매칭에 실패함
			j = pi[j - 1]; // 매칭된 곳 까지의 max(접미사 = 접두사)인 위치로 돌아감
		if (s[i] == p[j]) { // 매칭에 성공했을 때
			if (j == m - 1) { // 문자열 검색에 성공했을 때
				ans.push_back(i - m + 1); // 문자열 위치를 push
				j = pi[j]; // max(접미사 = 접두사)인 위치로 돌아감
			}
			else {
				j++;
			}
		}
	}
	return ans;
}
