// 잔액, 입/출금, 송금을 처리합니다

public class Account {
    
    // 잔액 (초기값 0) 정수형은 값을 할당하지 않으면 기본적으로 0이 적용
    private int balance = 0;

    // 잔액 반환
    public int getBalance() {
        return balance;
    }

    // 입금 처리 (amount: 입금액)
    public void deposit(int amount) {
        if (amount < 0) { // 입금액이 마이너스인 경우 예외를 던진다
            throw new IllegalArgumentException("마이너스 입금 시도!");
        }
        // 잔액에 입금액을 더한다
        balance += amount;
        // balance = balance + amount와 같다
    }

    // 출금처리 (amount: 출금액)
    public void withdraw(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("마이너스 출금 시도!");
        } // 출금액이 잔액보다 큰 경우
        if (amount > balance) {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }
        // 잔액에서 출금액을 뺀다
        balance -= amount; // balance = balance - amount와 같다
    }

    // 송금
    // to는 받는 사람, amount는 송금액
    public void trasfer(String to, int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("마이너스 송금시도!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("잔액이 부족합니다");
        }
        balance -= amount;
    }
}
