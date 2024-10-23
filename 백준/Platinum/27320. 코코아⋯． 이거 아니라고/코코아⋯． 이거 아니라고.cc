#include "books.h"

int rightParent[2000002], leftParent[2000002];
int find(int n, int isRight) {
    if (isRight) {
        if (n == rightParent[n]) return n;
        return rightParent[n] = find(rightParent[n], true);
    }
    else {
        if (n == leftParent[n]) return n;
        return leftParent[n] = find(leftParent[n], false);
    }
}

void solve(int N, int P, int Q) {
    for (int i = 0; i <= N * 2 + 2; i++) rightParent[i] = ((i + 1) / 2) * 2, leftParent[i] = (i / 2) * 2;
    for (int i = 0; i < N; i++) {
        int next, leftP = find(P, false), rightP = find(P, true), mergePoint;
        if (P > Q) {
            mergePoint = find(leftP - 2, false);
            leftParent[leftP] = mergePoint;
            rightParent[leftP] = rightP;
            next = answer(leftP);
        }
        else {
            mergePoint = find(rightP + 2, false);
            rightParent[rightP] = mergePoint;
            leftParent[rightP] = leftP;
            next = answer(rightP);
        } 
        P = Q, Q = next;
    }
}