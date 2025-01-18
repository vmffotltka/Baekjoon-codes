import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == 'J') bw.write("O");
        	else if (s.charAt(i) == 'O') bw.write("I");
        	else if (s.charAt(i) == 'I') bw.write("J");
        }
        bw.flush();
        bw.close(); br.close();
	}
}