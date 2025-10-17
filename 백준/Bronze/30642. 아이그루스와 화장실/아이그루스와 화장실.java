import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String mascot = br.readLine();
        int k = Integer.parseInt(br.readLine());
        
        int ans = 0;
        
        if (k % 2 == (mascot.equals("annyong") ? 1 : 0)) ans = k;
        else if (k + 1 <= n) ans = k + 1;
        else ans = k - 1;
        
        System.out.print(ans);
    }
}