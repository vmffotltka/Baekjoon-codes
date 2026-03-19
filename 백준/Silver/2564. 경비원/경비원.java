import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int garo = Integer.parseInt(st.nextToken());
        int sero = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken());
            arr.add(new int[] {pos, x});
        }
        st = new StringTokenizer(br.readLine());
        int pos = Integer.parseInt(st.nextToken()) - 1;
        int coor = Integer.parseInt(st.nextToken());
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int nextPos = arr.get(i)[0], nextCoor = arr.get(i)[1];
            if (pos == 0) {
                if (nextPos == 0) ans += Math.abs(nextCoor - coor);
                else if (nextPos == 1) ans += Math.min(coor + sero + nextCoor, garo - coor + sero + garo - nextCoor);
                else if (nextPos == 2) ans += coor + nextCoor;
                else ans += garo - coor + nextCoor;
            }
            else if (pos == 1) {
                if (nextPos == 0) ans += Math.min(coor + sero + nextCoor, garo - coor + sero + garo - nextCoor);
                else if (nextPos == 1) ans += Math.abs(nextCoor - coor);
                else if (nextPos == 2) ans += coor + sero - nextCoor;
                else ans += garo - coor + sero - nextCoor;
            }
            else if (pos == 2) {
                if (nextPos == 0) ans += coor + nextCoor;
                else if (nextPos == 1) ans += sero - nextCoor + nextCoor;
                else if (nextPos == 2) ans += Math.abs(coor - nextCoor);
                else ans += Math.min(coor + garo + nextCoor, sero - coor + garo + sero - nextCoor);
            }
            else {
                if (nextPos == 0) ans += coor + garo - nextCoor;
                else if (nextPos == 1) ans += sero - coor + garo - nextCoor;
                else if (nextPos == 2) ans += Math.min(coor + garo + nextCoor, sero - coor + garo + sero - nextCoor);
                else ans += Math.abs(coor - nextCoor);
            }
        }
        System.out.print(ans);
    }
}