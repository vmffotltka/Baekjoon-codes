#include <iostream>
#include <string>

using namespace std;

int main(void) {
    string str;
    cin >> str;
    const int gap = 'a' - 'A';
    for (int i = 0; i < str.length(); i++) {
        if ('a' <= str[i] && str[i] <= 'z')
            cout << (char)(str[i] - gap);
        else
            cout << (char)(str[i] + gap);
    }
    return 0;
}