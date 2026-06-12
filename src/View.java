import java.util.List;

public class View {
    
    public View() {}

    // 메인 화면
    // balance: 잔액, message: 입/출금, 송금을 처리하고 받은 메시지
    public void showHome(int balance, String message) {

        System.out.println();
        System.out.println("나의 은행 계좌");
        if (message != null) { // 메시지가 있으면 출력
            System.out.println("!" + message);
        }
        System.out.println("------------------------------");
        System.out.println("현재 잔액: " + balance + "원");
        System.out.println("------------------------------");
        System.out.println("예금: save 금액|출금: take 금액|송금: send 아이디 금액");
    }

    // 거래내역 페이지
    public void showHistory(List<String> history) { // history: 출력할 거래내역 데이터

        System.out.println();
        System.out.println("거래내역");
        System.out.println("------------------------------");
        if (history.size() < 1) { // 거래내역이 없을 때
            System.out.println("거래내역이 없습니다");
        } else { // 거래내역 출력
            for (int i = 0; i < history.size(); i++) {
                // i + 1: 인덱스로 넘버 만들기
                System.out.println((i + 1) + ". " + history.get(i));
            }
        }
        System.out.println("-------------------------------");
        System.out.println("돌아가기: home|종료: exit");
    }
}
