import java.io.*;
import java.util.*;

class Pair<First, Second> {
    public final First first;
    public final Second second;
    
    public Pair(First first, Second second) {
        this.first = first;
        this.second = second;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        List<Pair<Long, Long>> pairs = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            pairs.add(new Pair<>(Long.parseLong(input[0]),
                    Long.parseLong(input[1])));
        }
        
        Collections.sort(pairs, (p1, p2) -> {
            if (!p1.first.equals(p2.first)) {
                return p1.first.compareTo(p2.first);
            }
            return p1.second.compareTo(p2.second);
        });
        
        long ans = 0, start = pairs.get(0).first, end = pairs.get(0).second;
        
        for (int i = 1; i < n; i++) {
            long s = pairs.get(i).first;
            long e = pairs.get(i).second;
            
            if (s <= end) {
            	end = Math.max(end, e);
            } else {
                ans += end - start;
                start = s;
                end = e;
            }
        }
        ans += end - start;
        
        bw.write(String.valueOf(ans));
        bw.flush();
    }
}