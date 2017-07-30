package softuni.io.commands;

import softuni.models.viewModels.game.GameDetailsView;
import softuni.services.api.GameService;
import softuni.services.api.UserService;

public class GameDetailsCommand extends BaseCommand {

    private final static int GAME_DETAILS_ARGS_COUNT = 2;

    public GameDetailsCommand(String[] args, UserService userService,
                              GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        if (super.getArgs().length != GAME_DETAILS_ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid game details args count!");
        }

        String title = super.getArgs()[1];
        GameDetailsView gameDetailsView = super.getGameService().findGameDetailsByTitle(title);
        return gameDetailsView.toString();
    }
}
