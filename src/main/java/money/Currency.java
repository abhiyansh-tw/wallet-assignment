package money;

public enum Currency {

    RUPEE(1), DOLLAR(74.85);
    private final double factor;

    Currency(double factor) {
        this.factor = factor;
    }

    public double convertToBaseValue(double value) {
        return roundOff(value * this.factor);
    }

    public double convertFromBaseValue(double value) {
        return roundOff(value / this.factor);
    }

    private static double roundOff(double value) {
        return (double) Math.round(value * 100) / 100;
    }
}
