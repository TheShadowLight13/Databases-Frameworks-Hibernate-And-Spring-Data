package softuni.io.commands;

import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;

public class LoginCommand extends BaseCommand{

    private static final int LOGIN_ARGS_COUNT = 3;

    public LoginCommand(String[] args, UserService userService, GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        if (SessionData.getLoggedInUser() != null) {
            throw new IllegalArgumentException("User already logged in!");
        }

        if (super.getArgs().length != LOGIN_ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid login args count!");
        }

        String email = super.getArgs()[1];
        String password = super.getArgs()[2];

        LoggedInUser loggedInUser = this.getUserService().logIn(email, password);

        if (loggedInUser == null) {
            throw new IllegalArgumentException("Incorrect username / password!");
        }

        SessionData.setLoggedInUser(loggedInUser);
        return String.format("Successfully logged in %s!", loggedInUser.getFullName());
    }
}
