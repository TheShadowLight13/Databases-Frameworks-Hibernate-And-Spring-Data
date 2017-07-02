package pr04;

public class DecimalNumber {

    private String value;

    private double reversedNumber;

    public DecimalNumber(String value) {
        this.value = value;
        this.setReversedNumber();
    }

    public double getReversedNumber() {
        return this.reversedNumber;
    }

    private void setReversedNumber() {
        this.reversedNumber = Double.valueOf(new StringBuilder(this.value).reverse().toString());
    }
}