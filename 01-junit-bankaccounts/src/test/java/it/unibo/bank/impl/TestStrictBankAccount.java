package it.unibo.bank.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;

import it.unibo.bank.api.AccountHolder;
import it.unibo.bank.api.BankAccount;

public class TestStrictBankAccount {
    private AccountHolder aRossi;
    private AccountHolder aBianchi;

    @BeforeEach
    public void setUp() {
        this.aRossi = new AccountHolder("Andrea", "Rossi", 1);
        this.aBianchi = new AccountHolder("Alex", "Bianchi", 2);
    }

    @Test
    public void testNewStrictBankAccount() {
        BankAccount account = new StrictBankAccount(aRossi, 0.0);
        Assertions.assertEquals(0.0, account.getBalance());
        Assertions.assertEquals(0, account.getTransactionsCount());
        Assertions.assertSame(this.aRossi, account.getAccountHolder());
    }

    @Test
    public void testchargeManagementFees() {
        BankAccount account = new StrictBankAccount(aRossi, 100.0);
        Assertions.assertEquals(100.0, account.getBalance());
        account.withdraw(aRossi.getUserID(), 50.0);
        account.chargeManagementFees(aRossi.getUserID());
        Assertions.assertEquals(44.9, account.getBalance());
    }
}
