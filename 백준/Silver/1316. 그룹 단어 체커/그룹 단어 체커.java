// 특정 문자(a)가 연속으로 나오는 것은 가능하지만
// 다른 문자(b)가 나온 후에 등장하면 안 됨
// 연속으로 등장하는지 확인(이전에 나왔던 문자 저장)해서 연속으로 나오는 것은 ㅇㅋ
// 이때까지 나왔던 문자 또 나오면 ㄴㄴ, 바로 다음 줄로 ㄱㄱ
// 줄 넘어가면 이전에 나왔던 문자, 이때까지 나왔던 문자 초기화
// 시간복잡도 N x L^2

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        for (int i=0; i<N; i++) {
            String word = br.readLine(); // 단어 입력 받기

            char checkChar = word.charAt(0); // 직전 문자 저장
            boolean isGroup = true;
            for (int j=1; j<word.length(); j++) {
                if (checkChar != word.charAt(j)) {
                    // 이전에 같은 문자가 나왔는지 확인
                    for (int k=0; k<j; k++) {
                        if (word.charAt(k) == word.charAt(j)) { // 같은 문자가 나옴
                            isGroup = false;
                            break; // 그룹 단어에 해당하지 않음
                        }
                    }
                // 같은 문자가 나오지 않았을 때
                checkChar = word.charAt(j);
                }
            }
            if (isGroup) ans++;
        }
        System.out.println(ans);
    }
}
