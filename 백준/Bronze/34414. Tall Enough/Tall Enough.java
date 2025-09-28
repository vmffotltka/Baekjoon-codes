import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean ans = true;
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
        	int p = Integer.parseInt(br.readLine());
        	if (p < 48) ans = false;
        }
        System.out.print(ans ? "True" : "False");
    }
}