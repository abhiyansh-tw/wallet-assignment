package wallet;

import money.Money;

import static money.Money.createRupee;

public class Wallet {
    private Money balance;

    public Wallet() {
        this.balance = createRupee(0);
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
