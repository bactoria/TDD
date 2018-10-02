package test;

public class AccountTest {

    public void testAccount() throws Exception {
        Account account = new Account();
        if (account == null) {
            throw new Exception("계좌 생성 실패");
        }
    }
}
