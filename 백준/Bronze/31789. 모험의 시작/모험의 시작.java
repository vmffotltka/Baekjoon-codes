import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int money = Integer.parseInt(st.nextToken());
        int attack = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            st =  new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int att = Integer.parseInt(st.nextToken());

            if (cost <= money && attack < att) {
                System.out.print("YES");
                return;
            }
        }
        System.out.print("NO");
    }
}