import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[][] grid = new int[h][w];
        for (int i = 0; i < h; i++) {
            String s = br.readLine();
            int cur = -1;
            for (int j = 0; j < w; j++) {
                if (s.charAt(j) == 'c')
                    cur = 0;
                else if (cur != -1)
                    cur++;
                grid[i][j] = cur;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++)
                sb.append(grid[i][j]).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }
}