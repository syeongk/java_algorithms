import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int ans = 0;

        for (int i = 0; i < N; i++) {
            String word = br.readLine();

            boolean[] seen = new boolean[26];
            boolean isGroup = true;

            char prev = word.charAt(0);
            seen[prev - 'a'] = true;

            for (int j = 1; j < word.length(); j++) {
                char cur = word.charAt(j);

                // 이전 문자와 달라졌을 때만 체크
                if (cur != prev) {
                    if (seen[cur - 'a']) {
                        isGroup = false;
                        break;
                    }
                    seen[cur - 'a'] = true;
                }
                prev = cur;
            }

            if (isGroup) ans++;
        }

        System.out.println(ans);
    }
}
