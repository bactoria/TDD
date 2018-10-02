package main;

public class Account {

    private int balance;

    public Account(int i) {
        this.balance = i;
    }

    public int getBalance() {
        return this.balance;
    }

    public void deposit(int money) {
        this.balance += money;
    }
}
