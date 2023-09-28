package _01StacksAndQueues._01Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01BrowserHistory2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> history = new ArrayDeque<>();

        String currentUrl = "";

        String command;
        while(!"Home".equals((command = scanner.nextLine()))) {
            if(command.equals("back")) {
                if(!history.isEmpty()) {
                    currentUrl = history.pop();
                } else {
                    System.out.println("no previous URLs");
                    continue;
                }
            } else {
                if(!currentUrl.equals("")) {
                    history.push(currentUrl);
                }
                currentUrl = command;
            }

            System.out.println(currentUrl);
        }
    }
}
