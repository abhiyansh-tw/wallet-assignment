package wallet;

import money.Money;

public class Wallet {
    private Money balance;

    public Wallet() {
        this.balance = Money.createRupee(0);
    }

    public Money getBalanceInRupee() {
        return this.balance.convertToRupee();
    }

    public Money getBalanceInDollar() {
        return this.balance.convertToDollar();
    }

    public void deposit(Money amount) {
        this.balance = this.balance.add(amount);
    }

    public Money withdraw(Money amount) {
        this.balance = this.balance.subtract(amount);
        return amount;
    }
}
