import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> idx = new HashMap<>();
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
        	int num = Integer.parseInt(st.nextToken());
        	freq.put(num, freq.getOrDefault(num, 0) + 1);
        	if (!idx.containsKey(num)) {
        		idx.put(num, i);
        	}
        }
        
        List<Integer> numbers = new ArrayList<>(freq.keySet());
        numbers.sort((num1, num2) -> {
        	int freq1 = freq.get(num1), freq2 = freq.get(num2);
        	if (freq1 != freq2) return freq2 - freq1;
        	else return idx.get(num1) - idx.get(num2);
        });
        
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
        	int cnt = freq.get(num);
        	for (int i = 0; i < cnt; i++) {
        		sb.append(num).append(' ');
        	}
        }
        System.out.print(sb);
    }
}