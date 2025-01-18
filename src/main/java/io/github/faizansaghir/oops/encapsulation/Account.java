package io.github.faizansaghir.oops.encapsulation;

public class Account {

    private int balance;
    public void deposit(int amount) {
        if(amount>0)
            balance+=amount;
    }
    public void withdraw(int amount) {
        if (amount > 0 && balance >= amount)
            balance -= amount;
    }
    public int getBalance() {
        return balance;
    }

}
