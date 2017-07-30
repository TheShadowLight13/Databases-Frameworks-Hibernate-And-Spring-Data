package softuni.models.bindingModels.user;

import softuni.validators.emailValidator.Email;
import softuni.validators.passwordValidator.Password;
import softuni.validators.passwordValidator.PasswordMatching;

import java.io.Serializable;

@PasswordMatching
public class RegisterUser implements Serializable{

    private static final long serialVersionUID = -4941480928142057454L;

    private String email;

    private String password;

    private String confirmPassword;

    private String fullName;

    public RegisterUser(String email, String password, String confirmPassword,
                        String fullName) {
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.fullName = fullName;
    }

    public RegisterUser() {
    }

    @Email
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Password(containsLowercase = true, containsUppercase = true, containsDigit = true)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getConfirmPassword() {
        return this.confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
