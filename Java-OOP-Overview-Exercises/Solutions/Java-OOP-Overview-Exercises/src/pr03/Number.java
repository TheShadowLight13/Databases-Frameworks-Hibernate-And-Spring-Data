package pr03;

public class Number {

    private int value;

    private String lastDigitName;

    public Number(int value) {
        this.value = value;
        this.setLastDigitName();
    }

    public int getValue() {
        return this.value;
    }

    public String getLastDigitName() {
        return this.lastDigitName;
    }

    public void setLastDigitName() {
        int lastDigit = this.getValue() % 10;

        switch (lastDigit) {
            case 0: this.lastDigitName = "zero"; break;
            case 1: this.lastDigitName = "one"; break;
            case 2: this.lastDigitName = "two"; break;
            case 3: this.lastDigitName = "three"; break;
            case 4: this.lastDigitName = "four"; break;
            case 5: this.lastDigitName = "five"; break;
            case 6: this.lastDigitName = "six"; break;
            case 7: this.lastDigitName = "seven"; break;
            case 8: this.lastDigitName = "eight"; break;
            case 9: this.lastDigitName = "nine"; break;
        }
    }
}
