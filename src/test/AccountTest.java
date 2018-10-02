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

    @Test
    public void testDeposit() throws Exception {
        Account account = new Account(10000);
        account.deposit(1000);
        assertEquals(11000, account.getBalance());
    }

    @Test
    public void testWithdraw() throws Exception {
        Account account = new Account(10000);
        account.withdraw(1000);
        assertEquals(9000, account.getBalance());
    }

}
