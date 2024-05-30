package eden;

import java.util.Scanner;

public class CensorDirtyWords {

    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("所有人:");
        String input = scanner.nextLine();

        String[] dirtyWords = { "cnm", "sb", "tmd" }; // 在这里添加您要过滤的脏话

        for (String dirtyWord : dirtyWords) {
            input = input.replaceAll(dirtyWord, "*".repeat(dirtyWord.length()));
        }

        
        System.out.println(input);

        scanner.close();
    }
}
