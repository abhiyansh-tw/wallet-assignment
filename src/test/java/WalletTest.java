import org.junit.jupiter.api.Test;

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
}
