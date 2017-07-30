package softuni.io.commands;

import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;

public class LogoutCommand extends BaseCommand {

    public LogoutCommand(String[] args, UserService userService, GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser == null) {
            throw new IllegalArgumentException("Cannot log out. No user was logged in.");
        }

        SessionData.setLoggedInUser(null);
        return String.format("User %s successfully logged out!",
                loggedInUser.getFullName());
    }
}
