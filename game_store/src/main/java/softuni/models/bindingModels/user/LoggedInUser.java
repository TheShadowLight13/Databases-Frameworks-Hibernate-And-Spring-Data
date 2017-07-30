package softuni.models.bindingModels.user;

import softuni.enums.Role;
import java.io.Serializable;

public class LoggedInUser implements Serializable{

    private static final long serialVersionUID = -4305302460171310789L;

    private Long id;

    private Role role;

    private String fullName;

    public LoggedInUser() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
