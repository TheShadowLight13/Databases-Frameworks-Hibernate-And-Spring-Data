package softuni.validators.passwordValidator;

import org.springframework.stereotype.Component;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PasswordValidator implements ConstraintValidator<Password, String>{

    private boolean containsDigit;

    private boolean containsUppercase;

    private boolean containsLowercase;

    private int minLength;

    @Override
    public void initialize(Password password) {
        this.containsDigit = password.containsDigit();
        this.containsUppercase = password.containsUppercase();
        this.containsLowercase = password.containsLowercase();
        this.minLength = password.minLength();
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (!(password.length() >= this.minLength)) {
            return false;
        }

        if (!password.matches(".*?[a-z].*") && this.containsLowercase) {
            return false;
        }

        if (!password.matches(".*?[A-Z].*") && this.containsUppercase) {
            return false;
        }

        if (!password.matches(".*?[0-9].*") && this.containsDigit) {
            return false;
        }

        return true;
    }
}
