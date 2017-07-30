package softuni.io.commands;

import softuni.enums.Role;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;

public class DeleteGameCommand extends BaseCommand{

    private static final int DELETE_ARGS_COUNT = 2;

    public DeleteGameCommand(String[] args, UserService userService,
                             GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser != null && loggedInUser.getRole() == Role.ADMINISTRATOR) {
            if (super.getArgs().length != DELETE_ARGS_COUNT) {
                throw new IllegalArgumentException("Invalid delete game args count!");
            }

            Long id = Long.valueOf(super.getArgs()[1]);
            super.getGameService().deleteById(id);
            return "GameView was deleted!";

        }else {
            return "You do not have permission to delete games! " +
                    "Please log in with admin account!";
        }
    }
}
