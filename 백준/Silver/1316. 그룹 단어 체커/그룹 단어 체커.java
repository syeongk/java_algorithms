import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;

        for (int i=0; i<N; i++) {
            String word = br.readLine();

            char cur = word.charAt(0);
            char prev = word.charAt(0);

            boolean isGroup = true;

            boolean[] seen = new boolean[26];
            seen[cur - 'a'] = true;

            for (int j=1; j<word.length(); j++) {
                cur = word.charAt(j);

                if (prev != cur) {
                    if (seen[cur - 'a']) {
                        isGroup = false;
                        break;
                    }
                }
                prev = cur;

                seen[cur - 'a'] = true;
            }
            if (isGroup) ans++;
        }
        System.out.println(ans);
    }
}
