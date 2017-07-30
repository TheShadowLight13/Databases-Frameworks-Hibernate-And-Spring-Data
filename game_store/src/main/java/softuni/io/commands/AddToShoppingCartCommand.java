package softuni.io.commands;

import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;

public class AddToShoppingCartCommand extends BaseCommand {

    private static final int ADD_TO_SHOPPING_CARD_ARGS_COUNT = 2;

    public AddToShoppingCartCommand(String[] args, UserService userService,
                                    GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser == null) {
            throw new IllegalArgumentException(
                    "You have to log in to add games in shopping cart!");
        }

        if (super.getArgs().length != ADD_TO_SHOPPING_CARD_ARGS_COUNT) {
            throw new IllegalArgumentException("Invalid command arguments!");
        }

        String gameTitle = super.getArgs()[1];
        EditGame editGame = super.getGameService().findByTitle(gameTitle);
        super.getUserService().addGameToShoppingCard(editGame);
        return String.format("%s added to cart!", gameTitle);
    }
}
