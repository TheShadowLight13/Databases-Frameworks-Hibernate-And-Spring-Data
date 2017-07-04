package pr03.models;

import pr03.interfaces.ISmartPhone;

public class SmartPhone implements ISmartPhone {

    @Override
    public String callNumber(String number) {
        if (!isValidNumber(number)) {
            throw new IllegalArgumentException("Invalid number!");
        }

        return String.format("Calling... %s", number);
    }

    @Override
    public String browseURL(String URL) {
        if (!isValidURL(URL)) {
            throw new IllegalArgumentException("Invalid URL!");
        }

        return String.format("Browsing: %s!", URL);
    }

    private boolean isValidURL(String URL) {
        for (int i = 0; i < URL.length(); i++) {
            char currSymbol = URL.charAt(i);

            if (Character.isDigit(currSymbol)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidNumber(String number) {
        for (int i = 0; i < number.length(); i++) {
            char currSymbol = number.charAt(i);

            if (!Character.isDigit(currSymbol)) {
                return false;
            }
        }

        return true;
    }
}
