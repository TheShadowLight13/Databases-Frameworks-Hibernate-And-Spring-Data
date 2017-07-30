package softuni.io.commands;

import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.viewModels.game.GameView;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;
import java.util.Set;

public class OwnedGamesCommand extends BaseCommand {

    public OwnedGamesCommand(String[] args, UserService userService,
                             GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser == null) {
            throw new IllegalArgumentException(
                    "You have to log in to view all bought games!");
        }

        Set<GameView> boughtGames = super.getUserService()
                .getAllBoughtGamesView(loggedInUser.getId());
        StringBuilder boughtGamesInfo = new StringBuilder();
        for (GameView boughtGame : boughtGames) {
            boughtGamesInfo.append(String.format("%s%n", boughtGame));
        }

        if (boughtGamesInfo.length() > 0) {
            boughtGamesInfo.setLength(boughtGamesInfo.length() - 1);
        }else {
            boughtGamesInfo.append("You do not have bought games!");
        }

        return boughtGamesInfo.toString();
    }
}
