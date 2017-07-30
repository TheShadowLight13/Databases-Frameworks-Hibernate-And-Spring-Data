package softuni.io.commands;

import softuni.models.viewModels.game.GameView;
import softuni.services.api.GameService;
import softuni.services.api.UserService;

import java.util.List;

public class AllGamesCommand extends BaseCommand {

    public AllGamesCommand(String[] args, UserService userService,
                           GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        List<GameView> gameViews = super.getGameService().findAll();
        StringBuilder gamesInfo = new StringBuilder();
        for (GameView gameView : gameViews) {
            gamesInfo.append(String.format("%s%n", gameView));
        }

        if (gamesInfo.length() > 0) {
            gamesInfo.setLength(gamesInfo.length() - 1);
        }

        return gamesInfo.toString();
    }
}
