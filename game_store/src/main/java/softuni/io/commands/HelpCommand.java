package softuni.io.commands;

import softuni.services.api.GameService;
import softuni.services.api.UserService;

public class HelpCommand extends BaseCommand{

    public HelpCommand(String[] args, UserService userService,
                       GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        StringBuilder commandsInfo = new StringBuilder();
        commandsInfo.append("Supported commands: \n");
        commandsInfo.append("Register|<email>|<password>|<confirmPassword>|<fullName>\n");
        commandsInfo.append("Login|<username>|<password>\n");
        commandsInfo.append("Logout\n");
        commandsInfo.append("AddGame|<title>|<price>|<size>|<trailer>|<thumbnailURL>|<description>|<releaseDate>\n");
        commandsInfo.append("EditGame|<id>|<values>\n");
        commandsInfo.append("DeleteGame|<id>\n");
        commandsInfo.append("AllGames\n");
        commandsInfo.append("GameDetails|<gameTitle>\n");
        commandsInfo.append("OwnedGames\n");
        commandsInfo.append("AddToShoppingCart|<gameTitle>\n");
        commandsInfo.append("RemoveFromShoppingCart|<gameTitle>\n");
        commandsInfo.append("BuyGames");
        return commandsInfo.toString();
    }
}
