import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int x = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());

        int ans = 0;
        while (x < n) {
        	if (x % 3 == 0) x++;
        	else if (x % 3 == 1) x *= 2;
        	else x *= 3;
        	ans++;
        }
        System.out.print(ans);
    }
}