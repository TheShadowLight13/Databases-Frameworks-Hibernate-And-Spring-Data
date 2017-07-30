package softuni.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

public class DataValidator<T> {

    private Set<ConstraintViolation<T>> constraints;

    public DataValidator(T target) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.constraints = factory.getValidator().validate(target);
    }

    public String getInvalidParameterMessage() {
        for (ConstraintViolation<T> constraint : this.constraints) {
            return constraint.getMessage();
        }
        return null;
    }

    public boolean checkIsValid() {
        for (ConstraintViolation<T> constraint : this.constraints) {
            return false;
        }
        return true;
    }
}
