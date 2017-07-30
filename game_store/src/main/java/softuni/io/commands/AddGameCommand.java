package softuni.io.commands;

import softuni.enums.Role;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;
import softuni.utils.DataValidator;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddGameCommand extends BaseCommand {

    private static final int ADD_GAME_ARGS_COUNT = 8;

    public AddGameCommand(String[] args, UserService userService, GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();

        if (loggedInUser != null && loggedInUser.getRole() == Role.ADMINISTRATOR) {
            if (super.getArgs().length != ADD_GAME_ARGS_COUNT) {
                throw new IllegalArgumentException("Invalid add game args count!");
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String title = super.getArgs()[1];
            BigDecimal price = new BigDecimal(super.getArgs()[2]);
            Double size = Double.valueOf(super.getArgs()[3]);
            String trailerUrl = super.getArgs()[4];
            String thumbnailUrl = super.getArgs()[5];
            String description = super.getArgs()[6];
            Date releaseDate = null;
            try {
                releaseDate = dateFormat.parse(super.getArgs()[7]);
            } catch (ParseException e) {
                throw new IllegalArgumentException("Incorrect release date format!");
            }

            AddGame addGame = new AddGame(title, trailerUrl, thumbnailUrl, size, price,
                    description, releaseDate);
            DataValidator<AddGame> dataValidator = new DataValidator<>(addGame);
            if (!dataValidator.checkIsValid()) {
                throw new IllegalArgumentException(dataValidator.getInvalidParameterMessage());
            }

            super.getGameService().add(addGame);
            return String.format("Added %s", addGame.getTitle());
        } else {
            return "You do not have permission to add games! " +
                    "Please log in with admin account!";
        }
    }
}
