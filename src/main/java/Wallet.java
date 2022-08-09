public class Wallet {
    private Money balance;

    public Wallet() {
        this.balance = Money.createRupee(0);
    }

    public Money getBalanceInRupee() {
        return this.balance;
    }

    public void deposit(Money amount) {
        this.balance = this.balance.add(amount);
    }

    public Money withdraw(Money amount) {
        this.balance = this.balance.subtract(amount);
        return amount;
    }
}
