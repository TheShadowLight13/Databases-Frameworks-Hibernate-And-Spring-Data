package softuni.validators.passwordValidator;

import org.springframework.stereotype.Component;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Component
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordMatchingValidator.class)
public @interface PasswordMatching {

    String message() default "Password mismatch!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
