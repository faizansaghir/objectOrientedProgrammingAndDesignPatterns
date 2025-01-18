package io.github.faizansaghir.oops.encapsulation;

public class EncapsulationMain {
    public static void main(String[] args) {
        Account account = new Account();
        account.deposit(150);
        account.withdraw(50);
        System.out.println(account.getBalance());
    }
}
