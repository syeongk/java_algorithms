import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> stack;

        boolean flag;
        while (true) {
            String str = br.readLine();

            if (str.equals(".")) {
                break;
            }

            stack = new Stack<>();
            flag = true;

            for (int i = 0; i < str.length(); i++) {
                char cur = str.charAt(i);

                if (cur == '(' || cur == '[') {
                    stack.push(cur);
                }
                else if (cur == ')' || cur == ']') {
                    if (!stack.isEmpty()) {
                        char pop = stack.pop();

                        if ((pop == '(' && cur == ']')
                                || (pop == '[' && cur == ')')) {
                            flag = false;
                            break;
                        }
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag && stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }

    }
}
