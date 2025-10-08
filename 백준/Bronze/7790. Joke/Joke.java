import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        int ans = 0;
        while ((line = br.readLine()) != null) {
        	int idx = 0;
        	while ((idx = line.indexOf("joke", idx)) != -1) {
        		ans++;
        		idx++;
        	}
        }
        System.out.print(ans);
    }
}