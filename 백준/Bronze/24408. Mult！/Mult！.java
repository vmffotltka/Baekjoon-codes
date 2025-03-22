import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int first = -1;
        while (n-- > 0) {
        	int p = Integer.parseInt(br.readLine());
        	if (first == -1) first = p;
        	else if (p % first == 0) {
        		bw.write(p + "\n");
        		first = -1;
        	}
        }
        bw.flush();
        bw.close(); br.close();
    }
}