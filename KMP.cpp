#include <iostream>
#include <vector>
#include <string>

using namespace std;

/**
 * @brief Knuth-Morris-Pratt (KMP) Algorithm
 * Time Complexity: O(N + M)
 */
template <typename T = string> // 기본적으로 string 사용, vector<int> 등도 가능
struct KMP {
    /**
     * @brief 실패 함수 (Failure Function / Pi Array) 생성
     * @details pi[i]: p[0...i]의 접두사이자 접미사인 가장 긴 문자열의 길이
     */
    vector<int> getPi(const T& p) {
        int m = (int)p.size();
        vector<int> pi(m, 0);
        int j = 0;
        
        for (int i = 1; i < m; i++) {
            // 매칭 실패 시, 이전의 일치했던 구간의 정보를 이용해 점프
            while (j > 0 && p[i] != p[j]) {
                j = pi[j - 1];
            }
            // 매칭 성공 시, 접두사 포인터(j) 증가
            if (p[i] == p[j]) {
                pi[i] = ++j;
            }
        }
        return pi;
    }

    /**
     * @brief KMP 검색 수행
     * @param s 전체 텍스트 (Text)
     * @param p 찾을 패턴 (Pattern)
     * @return 패턴이 시작되는 모든 인덱스 (0-based)
     */
    vector<int> search(const T& s, const T& p) {
        vector<int> ans;
        if (p.empty()) return ans;

        vector<int> pi = getPi(p);
        int n = (int)s.size();
        int m = (int)p.size();
        int j = 0;

        for (int i = 0; i < n; i++) {
            // 불일치 발생 시 pi 배열을 이용해 j 위치 이동
            while (j > 0 && s[i] != p[j]) {
                j = pi[j - 1];
            }
            // 문자 일치
            if (s[i] == p[j]) {
                // 패턴의 끝까지 모두 일치했다면
                if (j == m - 1) {
                    ans.push_back(i - m + 1); // 시작 인덱스 저장
                    j = pi[j]; // 다음 매칭을 위해 점프
                } else {
                    j++; // 계속 검사
                }
            }
        }
        return ans;
    }
};

// --- 사용 예시 ---
int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    KMP<string> kmpStr;
    string text = "ABABABABC";
    string pattern = "ABA";

    // 1. 문자열 검색
    vector<int> result = kmpStr.search(text, pattern);
    
    cout << "Text: " << text << "\nPattern: " << pattern << "\nFound at: ";
    for (int idx : result) cout << idx << " "; 
    cout << "\n\n";

    // 2. 수열(vector<int>) 검색 (템플릿 활용)
    KMP<vector<int>> kmpVec;
    vector<int> tSeq = {1, 2, 1, 2, 3, 1, 2, 1, 2};
    vector<int> pSeq = {1, 2, 1};

    vector<int> seqResult = kmpVec.search(tSeq, pSeq);
    
    cout << "Found sequence at: ";
    for (int idx : seqResult) cout << idx << " ";
    cout << "\n";

    return 0;
}
