import java.util.Scanner;

public class BankAccountApp {
    public static void main(String[] args) throws Exception {
        
        //Controller
        Account account = new Account();
        TransactionManager transactionManager = new TransactionManager();
        View view = new View();
        Controller controller = new Controller(account, transactionManager, view);

        //CommandHandler
        Scanner scanner = new Scanner(System.in);
        CommandHandler commandHandler = new CommandHandler(controller, scanner);

        commandHandler.run();
        scanner.close();
    }
}
