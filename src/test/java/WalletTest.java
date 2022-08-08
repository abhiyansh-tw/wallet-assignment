import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {
    @Test
    void shouldInitialiseWalletWithZeroBalance() {
        Money expectedBalance = new Money(0);

        Wallet wallet = new Wallet();

        Money actualBalance = wallet.getBalance();
        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }

    @Test
    void shouldUpdateBalanceWhenMoneyIsAddedInTheWallet() {
        Wallet wallet = new Wallet();
        Money depositAmount = new Money(100);
        Money expectedBalance = new Money(100);

        wallet.deposit(depositAmount);

        Money actualBalance = wallet.getBalance();
        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }
}
