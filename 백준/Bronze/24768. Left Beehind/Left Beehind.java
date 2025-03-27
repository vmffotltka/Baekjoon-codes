import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	String[] input = br.readLine().split(" ");
        	int a = Integer.parseInt(input[0]);
        	int b = Integer.parseInt(input[1]);
        	if (a == 0 && b == 0) break;
        	if (a + b == 13) bw.write("Never speak again.\n");
        	else if (a > b) bw.write("To the convention.\n");
        	else if (a < b) bw.write("Left beehind.\n");
        	else bw.write("Undecided.\n");
        }
        bw.flush();
        bw.close(); br.close();
    }
}