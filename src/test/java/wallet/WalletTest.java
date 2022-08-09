package wallet;

import money.Money;
import org.junit.jupiter.api.Test;
import wallet.Wallet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {
    @Test
    void shouldInitialiseWalletWithZeroBalance() {
        Wallet wallet = new Wallet();
        assertThat(wallet.getBalanceInRupee(), is(equalTo(Money.createRupee(0))));
    }

    @Test
    void shouldUpdateBalanceWhenMoneyIsAddedInTheWallet() {
        Wallet wallet = new Wallet();
        Money depositAmount = Money.createRupee(100);
        Money expectedBalance = Money.createRupee(100);

        wallet.deposit(depositAmount);

        Money actualBalance = wallet.getBalanceInRupee();
        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }

    @Test
    void shouldHandleDepositsWithDifferentCurrencies() {
        Wallet wallet = new Wallet();
        Money depositAmountRupee = Money.createRupee(100);
        Money depositAmountDollar = Money.createDollar(1);
        Money expectedBalance = Money.createRupee(174.85);

        wallet.deposit(depositAmountRupee);
        wallet.deposit(depositAmountDollar);

        Money actualBalance = wallet.getBalanceInRupee();
        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }

    @Test
    void shouldHandleWithdrawalOfMoney() {
        Wallet wallet = new Wallet();
        wallet.deposit(Money.createRupee(100));
        wallet.deposit(Money.createDollar(4));
        Money withdrawalAmountRupee = Money.createRupee(10);
        Money withdrawalAmountDollar = Money.createDollar(2);
        Money expectedBalance = Money.createRupee(239.7);

        Money withdrawnRupee = wallet.withdraw(withdrawalAmountRupee);
        Money withdrawnDollar = wallet.withdraw(withdrawalAmountDollar);

        assertThat(withdrawnRupee, is(equalTo(withdrawalAmountRupee)));
        assertThat(withdrawnDollar, is(equalTo(withdrawalAmountDollar)));
        assertThat(wallet.getBalanceInRupee(), is(equalTo(expectedBalance)));
    }

    @Test
    void shouldHandleBalanceCheckInDifferentCurrencies() {
        Wallet wallet = new Wallet();
        wallet.deposit(Money.createRupee(50));
        wallet.deposit(Money.createDollar(1));
        Money expectedBalanceRupee = Money.createRupee(124.85);
        Money expectedBalanceDollar = Money.createDollar(1.67);

        Money actualBalanceInRupee = wallet.getBalanceInRupee();
        Money actualBalanceInDollar = wallet.getBalanceInDollar();

        assertThat(actualBalanceInRupee, is(equalTo(expectedBalanceRupee)));
        assertThat(actualBalanceInDollar, is(equalTo(expectedBalanceDollar)));
    }
}
