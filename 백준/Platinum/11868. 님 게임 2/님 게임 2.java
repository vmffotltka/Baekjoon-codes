import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int nim = Integer.parseInt(st.nextToken());
        for (int i = 1; i < n; i++) {
            nim ^= Integer.parseInt(st.nextToken());
        }
        System.out.print(nim == 0 ? "cubelover" : "koosaga");
    }
}