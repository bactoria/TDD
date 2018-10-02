package test;

import main.Account;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccountTest {

    @Test
    public void testAccount() throws Exception {
        Account account = new Account(10000);
    }

    @Test
    public void testGetBalance() throws Exception {
        Account account = new Account(10000);
        assertEquals("10000원으로 계좌 생성 후 잔고 조회", 10000, account.getBalance());

        account = new Account(1000);
        assertEquals("1000원으로 계좌 생성 후 잔고 조회", 1000, account.getBalance());

        account = new Account(100);
        assertEquals("100원으로 계좌 생성 후 잔고 조회", 100, account.getBalance());
    }

}
