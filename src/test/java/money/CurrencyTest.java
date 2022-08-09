package money;

import org.junit.jupiter.api.Test;

import static money.Currency.DOLLAR;
import static money.Currency.RUPEE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class CurrencyTest {
    @Test
    void shouldConvertToBaseValue() {
        assertThat(RUPEE.convertToBaseValue(10.0), is(equalTo(10.0)));
        assertThat(DOLLAR.convertToBaseValue(10), is(equalTo(748.5)));
    }

    @Test
    void shouldConvertFromBaseValue() {
        assertThat(RUPEE.convertFromBaseValue(10.0), is(equalTo(10.0)));
        assertThat(DOLLAR.convertFromBaseValue(50.0), is(equalTo(0.67)));
    }
}
