import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = br.readLine();
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int mx = 0;
        for (int j = 0; j < 5; j++) {
        	int cnt = 0;
        	for (int i = 0; i < n; i++) {
        		if (arr[i].charAt(j) == 'Y') cnt++;
        	}
        	if (cnt > mx) {
        		mx = cnt;
        		ans.clear();
        		ans.add(j + 1);
        	}
        	else if (cnt == mx) {
        		ans.add(j + 1);
        	}
        }
        for (int i = 0; i < ans.size(); i++) {
        	bw.write(ans.get(i) + (i == ans.size() - 1 ? "" : ","));
        }
        bw.flush();
    }
}