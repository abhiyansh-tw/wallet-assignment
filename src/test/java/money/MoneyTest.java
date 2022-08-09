package money;

import org.junit.jupiter.api.Test;

import static money.Money.createDollar;
import static money.Money.createRupee;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoneyTest {
    @Test
    void shouldEquateTwoMoneyWithSameCurrencyAndSameValue() {
        assertThat(createRupee(100), is(equalTo((createRupee(100)))));
        assertThat(createDollar(100), is(equalTo((createDollar(100)))));
    }

    @Test
    void shouldNotEquateTwoMoneyWithSameCurrencyAndDifferentValue() {
        assertThat(createRupee(100), is(not(equalTo(createRupee(200)))));
        assertThat(createDollar(100), is(not(equalTo(createDollar(200)))));
    }

    @Test
    void shouldNotEquateTwoMoneyWithInEquivalentValue() {
        assertThat(createRupee(100), is(not(equalTo((createDollar(100))))));
        assertThat(createRupee(374.24), is(not(equalTo((createDollar(5))))));
    }

    @Test
    void shouldEquateTwoMoneyWithEquivalentValue() {
        assertThat(createRupee(374.25), is(equalTo((createDollar(5)))));
    }

    @Test
    void shouldReturnThreeRupeeWhenTwoRupeeAndOneRupeeAreAdded() {
        Money oneRupee = createRupee(1);
        Money twoRupee = createRupee(2);
        Money threeRupee = createRupee(3);

        Money actualSum = oneRupee.add(twoRupee);

        assertThat(actualSum, is(equalTo(threeRupee)));
    }

    @Test
    void shouldReturnSeventyFivePointEightFiveRupeeWhenOneRupeeAndOneDollarAreAdded() {
        Money oneRupee = createRupee(1);
        Money oneDollar = createDollar(1);
        Money expectedSum = createRupee(75.85);

        Money actualSum = oneRupee.add(oneDollar);

        assertThat(actualSum, is(equalTo(expectedSum)));
    }

    @Test
    void shouldReturnZeroPointNineSevenDollarWhenTwoRupeeIsSubtractedFromOneDollar() {
        Money twoRupee = createRupee(2);
        Money oneDollar = createDollar(1);
        Money expectedResult = createDollar(0.97);

        Money actualResult = oneDollar.subtract(twoRupee);

        assertThat(actualResult, is(equalTo(expectedResult)));
    }

    @Test
    void shouldHandleConversionToDifferentCurrencies() {
        Money twoDollar = createDollar(2);
        Money tenRupee = createRupee(10);
        Money expectedTwoDollarInRupee = createRupee(149.7);
        Money expectedTenRupeeInDollar = createDollar(0.13);

        Money actualTwoDollarInRupee = twoDollar.convertToRupee();
        Money actualTenRupeeInDollar = tenRupee.convertToDollar();

        assertThat(actualTwoDollarInRupee, is(equalTo(expectedTwoDollarInRupee)));
        assertThat(actualTenRupeeInDollar, is(equalTo(expectedTenRupeeInDollar)));
    }
}
