import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoneyTest {
    @Test
    void shouldEquateTwoMoneyWithSameCurrencyAndSameValue() {
        assertThat(Money.createRupee(100), is(equalTo((Money.createRupee(100)))));
        assertThat(Money.createDollar(100), is(equalTo((Money.createDollar(100)))));
    }

    @Test
    void shouldNotEquateTwoMoneyWithSameCurrencyAndDifferentValue() {
        assertThat(Money.createRupee(100), is(not(equalTo(Money.createRupee(200)))));
        assertThat(Money.createDollar(100), is(not(equalTo(Money.createDollar(200)))));
    }

    @Test
    void shouldNotEquateTwoMoneyWithInEquivalentValue() {
        assertThat(Money.createRupee(100), is(not(equalTo((Money.createDollar(100))))));
        assertThat(Money.createRupee(374.24), is(not(equalTo((Money.createDollar(5))))));
    }

    @Test
    void shouldEquateTwoMoneyWithEquivalentValue() {
        assertThat(Money.createRupee(374.25), is(equalTo((Money.createDollar(5)))));
    }

    @Test
    void shouldReturnThreeRupeeWhenTwoRupeeAndOneRupeeAreAdded() {
        Money oneRupee = Money.createRupee(1);
        Money twoRupee = Money.createRupee(2);
        Money threeRupee = Money.createRupee(3);

        Money actualSum = oneRupee.add(twoRupee);

        assertThat(actualSum, is(equalTo(threeRupee)));
    }

    @Test
    void shouldReturnSeventyFivePointEightFiveRupeeWhenOneRupeeAndOneDollarAreAdded() {
        Money oneRupee = Money.createRupee(1);
        Money oneDollar = Money.createDollar(1);
        Money expectedSum = Money.createRupee(75.85);

        Money actualSum = oneRupee.add(oneDollar);

        assertThat(actualSum, is(equalTo(expectedSum)));
    }
}
