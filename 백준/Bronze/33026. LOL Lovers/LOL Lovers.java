import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int lCount = 0, oCount = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                lCount++;
            } else if (c == 'O') {
                oCount++;
            }
        }
        int curL = 0, curO = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == 'L') {
                curL++;
                lCount--;
            }
            else if (s.charAt(i) == 'O') {
                curO++;
                oCount--;
            }
            if (curL != lCount && curO != oCount) {
                System.out.print(i + 1);
                return;
            }
        }
        System.out.print(-1);
    }
}