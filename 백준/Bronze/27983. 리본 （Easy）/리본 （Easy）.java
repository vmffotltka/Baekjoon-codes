import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] x = br.readLine().split(" ");
        String[] l = br.readLine().split(" ");
        String[] c = br.readLine().split(" ");
        boolean ans = false;
        for (int i = 0; i < n; i++) {
        	for (int j = i + 1; j < n; j++) {
        		int x1 = Integer.parseInt(x[i]);
        		int x2 = Integer.parseInt(x[j]);
        		int l1 = Integer.parseInt(l[i]);
        		int l2 = Integer.parseInt(l[j]);
        		if (x2 - x1 <= l1 + l2 && !c[i].equals(c[j])) {
        			bw.write("YES\n" + (i + 1) + " " + (j + 1));
        			ans = true;
        			break;
        		}
        	}
        	if (ans) break;
        }
        if (!ans) bw.write("NO");
        bw.flush();
    }
}   