// 1글자 -> 2글자 -> 3글자 씩 확인
// 1글자 알파벳에 해당하는지 확인
// 2글자 크로아티아 알파벳에 해당하는지 확인
// 3글자 크로아티아 알파벳에 해당하는지 확인

// 기본적으로 2글자까지 확인해서 크로아티아 알파벳 우선

// c, d, l, n, s, z 로 시작하지 않으면 알파벳 처리

// c, d, l, n, s, z 로 시작하면 2,3번째 글자까지 확인
// 다음 글자가 크로아티아 알파벳에 해당하면 크로아티아 알파벳 처리
// 크로아티아 알파벳에 해당하지 않으면 첫번째 글자만 알파벳 처리 후 다음 글자부터 다시 체크
// 이때 d로 시작했으면 3번째 글자까지 확인

// ddfs length = 4, idx = 4

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
