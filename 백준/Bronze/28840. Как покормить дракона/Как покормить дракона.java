import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(":");
        String[] input2 = br.readLine().split(":");
        
        int time = Integer.parseInt(input1[0]) * 60 + Integer.parseInt(input1[1]);
        int next = Integer.parseInt(input2[0]) * 60 + Integer.parseInt(input2[1]) + 24 * 60;
        int dif = next - time;
        
        bw.write(String.format("%02d:%02d", dif / 60, dif % 60));
        bw.flush();
	}
}