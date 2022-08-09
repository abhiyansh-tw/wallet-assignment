import java.util.Objects;

public class Money {
    private final double value;
    private final Currency currency;

    private Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public static Money createRupee(double value){
        return new Money(value, Currency.RUPEE);
    }

    public static Money createDollar(double value){
        return new Money(value, Currency.DOLLAR);
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
        double totalBaseValue = this.currency.convertToBaseValue(this.value) + that.currency.convertToBaseValue(that.value);
        return new Money(this.currency.convertFromBaseValue(totalBaseValue), this.currency);
    }
}
