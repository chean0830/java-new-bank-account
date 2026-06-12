import java.util.Scanner;

public class CommandHandler {
    
    private Controller controller;
    private Scanner scanner;

    public CommandHandler(Controller controller, Scanner scanner) {
        this.controller = controller;
        this.scanner = scanner;
    }

    public void run() {
        // 초기 화면을 출력
        controller.home();

        while (true) {
            // 사용자 입력을 받고 처리하는 부분
            System.out.print("bankapp> ");
            String userInput = scanner.nextLine().trim();
            String[] parsed = userInput.split(" ");
            String command = parsed[0]; // 명령어

            try {
                switch (command) {
                    case "home":
                        controller.home();
                        break;
                    case "save":
                        controller.saveMoney(Integer.parseInt(parsed[1]));
                        break;
                    case "take":
                        controller.saveMoney(Integer.parseInt(parsed[1]));
                        break;
                    case "send":
                        controller.sendMoney(parsed[1], Integer.parseInt(parsed[2]));
                        break;
                    case "history":
                        controller.showHistory();
                        break;
                    case "exit":
                        System.out.println("bye");
                        return;
                    default:
                        System.out.println("유효하지 않은 명령어입니다");
                        break;
                }
            } catch (Exception e) { // 앱에서 발생하는 모든 예외를 처리하는 부분
                System.out.println("오류: " + e.getMessage());
            }
        }
    }
}
