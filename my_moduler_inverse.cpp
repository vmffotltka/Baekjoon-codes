int mul_inv(int r1, int r2) {
    int s, s1 = 1, s2 = 0;
    int r, q, r0 = r2;
    while (true) {
        q = r1 / r2;
        r = r1 - q * r2;
        s = s1 - q * s2;
        r1 = r2, r2 = r, s1 = s2, s2 = s;
        if (r == 0) break;
    }
    if (s1 < 0) s1 += r0;
    return s1;
}
