import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int dishes = Integer.parseInt(input[0]);
        int types = Integer.parseInt(input[1]);
        int streak = Integer.parseInt(input[2]);
        int coupon = Integer.parseInt(input[3]);
        
        int[] cnt = new int[types + 1];
        int[] arr = new int[dishes];
        
        for (int i = 0; i < dishes; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        
        int c = 0, mx = -1;
        for (int i = 0; i < streak; i++) {
        	if (cnt[arr[i]]++ == 0) c++;
        }
        mx = c + (cnt[coupon] == 0 ? 1 : 0);
        
        for (int i = 0; i < dishes; i++) {
        	int front = arr[i];
        	int back = arr[(i + streak) % dishes];
        	
        	if (--cnt[front] == 0) c--;
        	if (cnt[back]++ == 0) c++;
        	
        	mx = Math.max(mx, c + (cnt[coupon] == 0 ? 1 : 0));
        }
        bw.write(String.valueOf(mx));
        bw.flush();
    }
}