import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String[] input = br.readLine().split(" ");
        int floor = Integer.parseInt(input[1]);
        if (input[0].equals("residential")) {
        	if (floor == 1) bw.write("0");
        	else if (floor <= 5) bw.write("1");
        	else if (floor <= 10) bw.write("2");
        	else if (floor <= 15) bw.write("3");
        	else bw.write("4");
        }
        else if (input[0].equals("commercial")) {
        	if (floor == 1) bw.write("0");
        	else if (floor <= 7) bw.write("1");
        	else if (floor <= 14) bw.write("2");
        	else bw.write("3");
        }
        else {
        	if (floor == 1) bw.write("0");
        	else if (floor <= 4) bw.write("1");
        	else if (floor <= 8) bw.write("2");
        	else if (floor <= 12) bw.write("3");
        	else if (floor <= 16) bw.write("4");
        	else bw.write("5");
        }
        bw.flush();
        bw.close(); br.close();
    }
}