package softuni.io.commands;

import softuni.models.bindingModels.user.RegisterUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.utils.DataValidator;

public class RegisterCommand extends BaseCommand {

    private static final int REGISTER_ARGS_COUNT = 5;

    public RegisterCommand(String[] args, UserService userService,
                           GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        if (super.getArgs().length != REGISTER_ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid register args count!");
        }

        String email = super.getArgs()[1];

        if (super.getUserService().findByEmail(email) != null) {
            throw new IllegalArgumentException("User already exist!");
        }

        String password = super.getArgs()[2];
        String confirmPassword = super.getArgs()[3];
        String fullName = super.getArgs()[4];
        RegisterUser registerUser = new RegisterUser(email, password,
                confirmPassword, fullName);

        DataValidator<RegisterUser> validator = new DataValidator<>(registerUser);
        if (!validator.checkIsValid()) {
            throw new IllegalArgumentException(validator.getInvalidParameterMessage());
        }

        super.getUserService().register(registerUser);
        return String.format("%s was registered.", registerUser.getFullName());
    }
}
