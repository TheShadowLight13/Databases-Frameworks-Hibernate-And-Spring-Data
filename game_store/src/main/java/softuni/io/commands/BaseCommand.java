package softuni.io.commands;

import softuni.services.api.GameService;
import softuni.services.api.UserService;

public abstract class BaseCommand implements Executable {

    private String[] args;

    private UserService userService;

    private GameService gameService;

    protected BaseCommand(String[] args, UserService userService, GameService gameService) {
        this.args = args;
        this.userService = userService;
        this.gameService = gameService;
    }

    protected String[] getArgs() {
        return this.args;
    }

    protected UserService getUserService() {
        return this.userService;
    }

    protected GameService getGameService() {
        return this.gameService;
    }
}
