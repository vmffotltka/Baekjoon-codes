import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), "/");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        
        StringBuilder sb = new StringBuilder();
        if (a <= 12 && b <= 12) sb.append("either");
        else if (a > 12) sb.append("EU");
        else if (b > 12) sb.append("US");
        
        System.out.print(sb);
    }
}