
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int ans = 0;

        int i = 0;
        while (i < str.length()) {
            // dz= 인 경우
            if (i + 2 < str.length()
                    && str.charAt(i) == 'd'
                    && str.charAt(i + 1) == 'z'
                    && str.charAt(i + 2) == '=') {
                ans++;
                i += 3;
            }
            else if (i + 1 < str.length()
                    && ((str.charAt(i) == 'c' && (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-'))
                    || (str.charAt(i) == 'd' && (str.charAt(i + 1) == '-'))
                    || (str.charAt(i) == 'l' && (str.charAt(i + 1) == 'j'))
                    || (str.charAt(i) == 'n' && (str.charAt(i + 1) == 'j'))
                    || (str.charAt(i) == 's' && (str.charAt(i + 1) == '='))
                    || (str.charAt(i) == 'z' && (str.charAt(i + 1) == '=')))
            )
            {
                ans++;
                i += 2;
            }
            else {
                ans++;
                i += 1;
            }
        }
        System.out.println(ans);
    }
}
