import java.io.*;
import java.util.*;

public class Main {

    static int ALPHABETS = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String s = st.nextToken();

        int shift = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append((char) ((s.charAt(i) - 'A' + shift) % ALPHABETS + 'A'));
            shift = (shift * 2) % ALPHABETS;
        }
        System.out.print(sb);
    }
}