import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Integer> m = new HashMap<>();
        int[] dy = { 0, 0, -1, 1, 1, 1, -1, -1 };
        int[] dx = { 1, -1, 0, 0, 1, -1, 1, -1 };
        String[] dir = { "R", "L", "B", "T", "RT", "LT", "RB", "LB" };
        for (int i = 0; i < 8; i++){
        	m.put(dir[i], i);
        }
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        String king = st.nextToken(), stone = st.nextToken();
        int kingX = king.charAt(0) - 'A', kingY = king.charAt(1) - '1';
        int stoneX = stone.charAt(0) - 'A', stoneY = stone.charAt(1) - '1';
        
        int q = Integer.parseInt(st.nextToken());
        while (q-- > 0) {
        	String cmd = br.readLine();
        	int y = dy[m.get(cmd)], x = dx[m.get(cmd)];
        	int ny = kingY + y, nx = kingX + x;
        	if (ny == stoneY && nx == stoneX) {
        		ny = stoneY + y;
        		nx = stoneX + x;
        		if (ny < 0 || ny > 7 || nx < 0 || nx > 7)
        			continue;
        		kingX = stoneX;
        		kingY = stoneY;
        		stoneY = ny;
        		stoneX = nx;
        		continue;
        	}
    		if (ny < 0 || ny > 7 || nx < 0 || nx > 7)
    			continue;
    		kingX = nx;
    		kingY = ny;
        }
        StringBuilder sb = new StringBuilder()
        		.append((char)(kingX + 'A'))
        		.append(kingY + 1).append('\n')
        		.append((char)(stoneX + 'A'))
        		.append(stoneY + 1);
        System.out.print(sb);
    }
}