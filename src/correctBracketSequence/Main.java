package correctBracketSequence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = readFile("src/correctBracketSequence/input.txt");
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char sym = s.charAt(i);
            if (sym == '(' || sym == '{' || sym == '[') {
                stack.push(sym);
            } else if (stack.empty() && !s.equals("")) {
                System.out.println("no");
                return;
            } else if (((char)stack.peek() == '(' && sym == ')' || ((char)stack.peek() == '{' && sym == '}') ||
                    ((char)stack.peek() == '[' && sym == ']'))) {
                stack.pop();
            } else {
                System.out.println("no");
                return;
            }
        }
        if (stack.empty()) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }

    public static String readFile(String path) {
        String input = "";
        try (FileReader fr = new FileReader(path);
             BufferedReader reader = new BufferedReader(fr)){
            String line = "";
            while (line != null) {
                input += line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        input.trim();
        return input;
    }
}
