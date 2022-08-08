import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MoneyTest {
    @Test
    void shouldEquateTwoMoneyWithSameValue() {
        assertThat(new Money(100), is(equalTo((new Money(100)))));
    }

    @Test
    void shouldNotEquateTwoMoneyWithDifferentValue() {
        assertThat(new Money(100), is(not(equalTo(new Money(200)))));
    }

    @Test
    void shouldReturnMoneyOfValueTwoWhenTwoMoneyOfValueOneAreAdded() {
        Money money = new Money(1);
        Money anotherMoney = new Money(1);
        Money expectedSum = new Money(2);

        Money actualSum = money.add(anotherMoney);

        assertThat(actualSum, is(equalTo(expectedSum)));
    }
}
