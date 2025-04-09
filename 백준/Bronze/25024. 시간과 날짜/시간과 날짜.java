import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int x = Integer.parseInt(input[0]);
        	int y = Integer.parseInt(input[1]);
        	
        	bw.write(x < 24 && y < 60 ? "Yes " : "No ");
        	if (1 <= x && x <= 12 && 1 <= y && y <= 31) {
        		if (x == 4 || x == 6 || x == 9 || x == 11)
        			bw.write(y == 31 ? "No\n" : "Yes\n");
        		else if (x == 2 && y >= 30)
        			bw.write("No\n");
        		else
        			bw.write("Yes\n");
        	}
        	else
        		bw.write("No\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}