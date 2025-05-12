import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
        	String[] input = br.readLine().split(" ");
        	int usaGold = Integer.parseInt(input[0]);
        	int usaSilver = Integer.parseInt(input[1]);
        	int usaBronze = Integer.parseInt(input[2]);
        	int rusGold = Integer.parseInt(input[3]);
        	int rusSilver = Integer.parseInt(input[4]);
        	int rusBronze = Integer.parseInt(input[5]);
        	
        	int usaCount = usaGold + usaSilver + usaBronze;
        	int rusCount = rusGold + rusSilver + rusBronze;
        	
        	boolean win = true;
        	if (usaGold < rusGold) win = false;
        	else if (usaGold == rusGold && usaSilver < rusSilver) win = false;
        	else if (usaGold == rusGold && usaSilver == rusSilver && usaBronze <= rusBronze) win = false;
        	
        	for (int i = 0; i < 6; i++) bw.write(input[i] + " ");
        	bw.write("\n");
        	bw.write(win && usaCount > rusCount ? "both\n" : (win && usaCount <= rusCount  ? "color\n" : (!win && usaCount > rusCount ? "count\n" : "none\n")));
        	bw.write("\n");
        }
        
        bw.flush();
        bw.close(); br.close();
    }
}