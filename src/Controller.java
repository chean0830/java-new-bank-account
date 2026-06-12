import java.util.List;

public class Controller {
    
    private Account account;
    private TransactionManager transactionManager;
    private View view;

    public Controller(Account account, TransactionManager transactionManager, View view) {
        this.account = account;
        this. transactionManager = transactionManager;
        this. view = view;
    }

    // 메인화면 처리
    public void home() {
        // 화면 렌더링은 뷰에게 맡긴다
        view.showHome(account.getBalance(), null);
    }

    public void saveMoney(int amount) { // amount는 입금액
        // 실제 입금처리는 Account 객체를 거쳐야합니다
        account.deposit(amount);

        // 거래 내역 처리는 transactionManager에게 맡긴다
        transactionManager.updateHistory(amount + "원 입금");

        // 성공 메시지
        String message = "성공적으로 " + amount + "원 입금했습니다";
        // 현재 잔액과 성공 메시지를 뷰에게 전달
        view.showHome(account.getBalance(), message);
    }

    // 출금 처리
    public void takeMoney(int amount) {
        // 실제 출금처리는 Account 객체에게 맡긴다
        account.withdraw(amount);

        // 거래내역처리는 transactionManager에게 맡긴다
        transactionManager.updateHistory(amount + "원 출금");

        // 성공 메시지
        String message = "성공적으로 " + amount + "원 출금했습니다";
        
        view.showHome(account.getBalance(), message);
    }

    // 송금 담당
    public void sendMoney(String to, int amount) { // to: 받는 사람

        // 실제 송금처리는 Account에게 맡기고
        account.trasfer(to, amount);

        // 거래 내역 처리는 매니저에게 맡기고
        String format = String.format("%d원 송금 (%s)", amount, to);
        transactionManager.updateHistory(format);

        // 성공 메시지
        String message = String.format("성공적으로 %s에게 %원 송금하였습니다", to, amount);
        view.showHome(account.getBalance(), message);
    }

    // 거래내역 처리
    public void showHistory() {
        // 매니저에게 거래내역 데이터를 요청하고
        List<String> history = transactionManager.getHistory();
        // 화면에 출력
        view.showHistory(history);
    }
}
