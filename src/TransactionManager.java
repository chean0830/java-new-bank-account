// 거래 내역을 관리하는 객체

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    
    // 거래 내역
    private List<String> history = new ArrayList<>();

    public TransactionManager() {}

    // 거래내역을 갱신한다 (content: 새로 추가되는 거래내역)
    public void updateHistory(String content) {
        history.add(content);
    }

    // 거래내역을 반환한다
    public List<String> getHistory() {
        return history;
    }
}
