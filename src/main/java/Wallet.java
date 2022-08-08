public class Wallet {
    private Money balance;

    public Wallet() {
        this.balance = new Money(0);
    }

    public Money getBalance() {
        return this.balance;
    }

    public void deposit(Money amount) {
        this.balance = this.balance.add(amount);
    }
}
