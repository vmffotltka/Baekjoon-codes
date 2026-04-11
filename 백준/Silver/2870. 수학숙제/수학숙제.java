import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if ('0' <= s.charAt(j) && s.charAt(j) <= '9')
                    num.append(s.charAt(j));
                else {
                    if (num.isEmpty()) continue;
                    if (num.charAt(0) == '0') {
                        for (int k = 0; k < num.length(); k++) {
                            if (num.charAt(k) != '0') {
                                num.delete(0, k);
                                break;
                            }
                            else if (k == num.length() - 1)
                                num = new StringBuilder().append("0");
                        }
                        list.add(num.toString());
                    }
                    else
                        list.add(num.toString());
                    num = new StringBuilder();
                }
            }
            if (num.isEmpty()) continue;
            if (num.charAt(0) == '0') {
                for (int k = 0; k < num.length(); k++) {
                    if (num.charAt(k) != '0') {
                        num.delete(0, k);
                        break;
                    }
                    else if (k == num.length() - 1)
                        num = new StringBuilder().append("0");
                }
                list.add(num.toString());
            }
            else
                list.add(num.toString());
        }
        list.sort((s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            }
            else {
                return s1.length() - s2.length();
            }
        });
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.print(sb);
    }
}