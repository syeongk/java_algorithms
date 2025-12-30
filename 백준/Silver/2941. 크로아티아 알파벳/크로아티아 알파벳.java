import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        StringBuilder cur = new StringBuilder();

        String[] alphabets = {"c", "d", "l", "n", "s", "z"};
        String[] cros = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

        int ans = 0;

        int condition = 0;

        int i = 0;
        while (i < str.length()) {
            if (condition == 1) {
                i += 1;
            } else if (condition == 2) {
                i += 2;
            } else if (condition == 3) {
                i += 3;
            }

            if (i >= str.length()) break;

            condition = 0;

            cur.setLength(0);
            cur.append(str.charAt(i));

            // c,d,l,n,s,z 로 시작하는지 확인
            for (String alphabet : alphabets) {
                if (cur.toString().equals(alphabet)) {

                    if (i + 1 < str.length()) {
                        cur.append(str.charAt(i + 1)); // cur : c=, nj

                        // 크로아티아 알파벳에 해당하는지 확인
                        for (String cro : cros) {
                            if (cur.toString().equals(cro)) {
                                ans++;
                                condition = 2;
                                break;
                            }
                        }
                    } else {
                        break;
                    }

                    // 크로아티아 알파벳(dz=)에 해당하는지 확인
                    if (cur.toString().equals("dz")) {

                        if (i + 2 < str.length()) {
                            cur.append(str.charAt(i + 2));

                            if (cur.toString().equals("dz=")) {
                                ans++;
                                condition = 3;
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
                // 크로아티아 알파벳을 찾은 경우
                if (condition >= 2) {
                    break;
                }
            }
            // c,d,l,n,s,z 로 시작하지 않았을 때, 마지막 글자일 때
            if (condition <= 1) {
                ans++;
                condition = 1;
            }
        }
        System.out.println(ans);
    }
}
