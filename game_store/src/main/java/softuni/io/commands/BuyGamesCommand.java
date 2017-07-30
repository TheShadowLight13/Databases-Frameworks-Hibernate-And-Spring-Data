package softuni.io.commands;

import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;

public class BuyGamesCommand extends BaseCommand{

    public BuyGamesCommand(String[] args, UserService userService,
                           GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser == null) {
            throw new IllegalArgumentException(
                    "You have to log in to buy games!");
        }

        String boughtGamesInfo =  super.getUserService().buyGames();
        return boughtGamesInfo;
    }
}
