import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String bomb = br.readLine();
        int bombLen = bomb.length();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            sb.append(c);

            // 폭발 문자열(bomb) 있는지 확인
            if (sb.length() >= bombLen && c == bomb.charAt(bombLen - 1)) {
                int cnt = 0;

                for (int j = 0; j < bombLen; j++) {
                    // 폭발 문자열(bomb) 아님
                    if (sb.charAt(sb.length() - bombLen + j) != bomb.charAt(j)) {
                        break;
                    } else {
                        cnt++;
                    }

                    // 폭발 문자열(bomb)일 때
                    if (cnt == bombLen) {
                        sb.delete(sb.length() - bombLen, sb.length());
                    }
                }
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb);
        }
    }
}
