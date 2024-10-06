#include <bits/stdc++.h>

using namespace std;

// 모듈로 연산에 사용할 상수
constexpr int MOD = 786433; // 소수
constexpr int FFT_SIZE = 3 << 18; // FFT 크기
constexpr int ROOT = 10; // 원시 근

using Polynomial = vector<int>; // 다항식을 벡터로 정의

// 수학 연산 함수 정의
int Add(int a, int b) {
    return (a + b < MOD) ? (a + b) : (a + b - MOD); // 모듈로 덧셈
}

int Subtract(int a, int b) {
    return (a >= b) ? (a - b) : (a - b + MOD); // 모듈로 뺄셈
}

int Multiply(int a, int b) {
    return 1LL * a * b % MOD; // 모듈로 곱셈
}

// 고속 푸리에 변환 함수
void FastFourierTransform(Polynomial& polynomial, int root) {
    const int size = polynomial.size(); // 다항식의 크기 저장

    // 기저 사례: 다항식의 크기가 3인 경우
    if (size == 3) {
        long coeff0 = polynomial[0], coeff1 = polynomial[1], coeff2 = polynomial[2];

        // f(0) 계산
        polynomial[0] = Add(coeff0, Add(coeff1, coeff2));

        // f(1) 계산: w^0, w^1, w^2 항을 곱해 합산
        polynomial[1] = Add(coeff0, Add(Multiply(coeff1, root), Multiply(coeff2, Multiply(root, root))));

        // f(2) 계산: w^0, w^1, w^2 항을 곱해 합산
        polynomial[2] = Add(coeff0, Add(Multiply(coeff1, Multiply(root, root)), Multiply(coeff2, Multiply(root, root * root))));
    }
    else {
        Polynomial even_terms(size / 2), odd_terms(size / 2); // 짝수 및 홀수 항 저장

        // 짝수 및 홀수 인덱스에 따라 항을 분리
        for (int idx = 0; idx < size; idx += 2) {
            even_terms[idx / 2] = polynomial[idx]; // 짝수 항 추가
            odd_terms[idx / 2] = polynomial[idx + 1]; // 홀수 항 추가
        }

        // 짝수 및 홀수 항에 대해 FFT 호출
        FastFourierTransform(even_terms, Multiply(root, root)); // 짝수 항에 대한 FFT
        FastFourierTransform(odd_terms, Multiply(root, root)); // 홀수 항에 대한 FFT

        // 결과 결합
        for (int idx = 0, temp = 1; idx < size / 2; idx++) {
            // 첫 번째 절반: f(0) + f(1) * w^0, f(2) + f(1) * w^1
            polynomial[idx] = Add(even_terms[idx], Multiply(temp, odd_terms[idx]));
            // 두 번째 절반: f(0) - f(1) * w^0, f(2) - f(1) * w^1
            polynomial[idx + size / 2] = Subtract(even_terms[idx], Multiply(temp, odd_terms[idx]));
            temp = Multiply(temp, root); // 원시 근을 곱하여 temp 업데이트
        }
    }
}

int inverse[FFT_SIZE | 1];

int main() {
    ios::sync_with_stdio(false); // 빠른 입출력 설정
    cin.tie(nullptr); // cin과 cout의 동기화 해제

    int degree; // 다항식의 차수
    cin >> degree;

    Polynomial polynomial(FFT_SIZE, 0); // 다항식 초기화, 크기는 FFT_SIZE로 설정
    for (int i = 0; i <= degree; i++) {
        cin >> polynomial[i]; // 계수 입력
    }
    for (int i = 0, temp = 1; i < FFT_SIZE; i++, temp = Multiply(temp, ROOT)) {
        inverse[temp] = i;
    }

    // FFT 수행
    int f0 = polynomial[0]; // f(0) 저장
    FastFourierTransform(polynomial, ROOT); // FFT 호출

    int query_count; // 쿼리 개수
    cin >> query_count; // 쿼리 입력

    // 쿼리 처리
    while (query_count--) {
        int x; // 입력값
        cin >> x; // 쿼리 값 입력
        if (x == 0) {
            cout << f0 << '\n'; // f(0) 출력
        }
        else {
            cout << polynomial[inverse[x]] << '\n'; // f(x) 출력
        }
    }
}