package money;

import java.util.Objects;

import static money.Currency.DOLLAR;
import static money.Currency.RUPEE;

public class Money {
    private final double value;
    private final Currency currency;

    private Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money createRupee(double value) {
        return new Money(value, RUPEE);
    }

    public static Money createDollar(double value) {
        return new Money(value, DOLLAR);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Money that = (Money) o;
        return this.currency.convertToBaseValue(this.value) == that.currency.convertToBaseValue(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, currency);
    }

    public Money add(Money that) {
        double baseValue = this.currency.convertToBaseValue(this.value) + that.currency.convertToBaseValue(that.value);
        return new Money(this.currency.convertFromBaseValue(baseValue), this.currency);
    }

    public Money subtract(Money that) {
        double baseValue = this.currency.convertToBaseValue(this.value) - that.currency.convertToBaseValue(that.value);
        return new Money(this.currency.convertFromBaseValue(baseValue), this.currency);
    }

    private Money convertTo(Currency curr) {
        double baseValue = this.currency.convertToBaseValue(this.value);
        double convertedValue = curr.convertFromBaseValue(baseValue);
        return new Money(convertedValue, curr);
    }

    public Money convertToRupee() {
        return convertTo(RUPEE);
    }

    public Money convertToDollar() {
        return convertTo(DOLLAR);
    }
}
