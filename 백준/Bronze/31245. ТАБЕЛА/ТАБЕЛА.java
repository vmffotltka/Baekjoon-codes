import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        sb.append(st.nextToken()).append(st.nextToken()).append(st.nextToken());
        for (int i = 2; i < 6; i += 2) {
        	if (sb.charAt(i - 1) == sb.charAt(i)) sb.replace(i, i + 1, "\'");
        }
        System.out.print(sb);
    }
}