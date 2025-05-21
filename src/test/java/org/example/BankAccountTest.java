package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {

    @Test
    void testValidAccountCreation() {
        BankAccount account = new BankAccount("Alice", 100);
        assertEquals(100, account.getBalance());
        assertEquals("Alice", account.getOwner());
    }

    @Test
    void testInvalidAccountCreation() {
        assertThrows(IllegalArgumentException.class, () -> new BankAccount("Bob", -50));
    }

    @Test
    void testValidDeposit() {
        BankAccount account = new BankAccount("Charlie", 100);
        account.deposit(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testInvalidDeposit() {
        BankAccount account = new BankAccount("Dave", 100);
        assertThrows(IllegalArgumentException.class, () -> account.deposit(0));
        assertThrows(IllegalArgumentException.class, () -> account.deposit(-20));
    }

    @Test
    void testValidWithdrawal() {
        BankAccount account = new BankAccount("Eve", 200);
        account.withdraw(50);
        assertEquals(150, account.getBalance());
    }

    @Test
    void testOverdraftWithdrawal() {
        BankAccount account = new BankAccount("Frank", 50);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(100));
    }

    @Test
    void testInvalidWithdrawalAmount() {
        BankAccount account = new BankAccount("Grace", 100);
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(0));
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(-30));
    }
}