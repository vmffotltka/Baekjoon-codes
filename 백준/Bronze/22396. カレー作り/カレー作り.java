import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int[] input = new int[4];
        	for (int i = 0; i < 4; i++)
        		input[i] = Integer.parseInt(st.nextToken());
        	if (input[0] + input[1] + input[2] + input[3] == 0) break;
        	if (input[0] >= input[1] * input[2]) bw.write("0\n");
        	else
        		bw.write((input[2] * input[1] - input[0] + input[3] - 1) / input[3] + "\n");
        }
        bw.flush();
        bw.close(); br.close();
	}
}