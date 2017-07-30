package softuni.io.commands;

import softuni.enums.Role;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.services.api.GameService;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;
import softuni.utils.DataValidator;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class EditGameCommand extends BaseCommand {

    private static final int MIN_ARGS_COUNT = 2;

    public EditGameCommand(String[] args, UserService userService,
                           GameService gameService) {
        super(args, userService, gameService);
    }

    @Override
    public String execute() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        if (loggedInUser != null && loggedInUser.getRole() == Role.ADMINISTRATOR) {
            if (super.getArgs().length < MIN_ARGS_COUNT) {
                throw new IllegalArgumentException("Invalid edit game args count!");
            }

            Long id = Long.valueOf(super.getArgs()[1]);
            List<String> gameArgs = Arrays.stream(super.getArgs()).skip(2)
                    .collect(Collectors.toList());
            if (gameArgs.isEmpty()) {
                throw new IllegalArgumentException("Invalid edit game args count!");
            }

            EditGame editGame = createEditGame(id, gameArgs);

            DataValidator<EditGame> dataValidator = new DataValidator<>(editGame);
            if (!dataValidator.checkIsValid()) {
                throw new IllegalArgumentException(dataValidator.getInvalidParameterMessage());
            }

            super.getGameService().editGame(editGame);
            return String.format("Edited %s successfully", editGame.getTitle());

        } else {
            return "You do not have permission to edit games! " +
                    "Please log in with admin account!";
        }
    }

    private EditGame createEditGame(Long id, List<String> gameArgs) {
        EditGame editGame = this.getGameService().findById(id);

        Field[] fields = EditGame.class.getDeclaredFields();
        for (String gameArg : gameArgs) {
            String fieldName = gameArg.split("=")[0];
            String fieldValue = gameArg.split("=")[1];
            for (Field field : fields) {
                if (fieldName.equals(field.getName())) {
                    field.setAccessible(true);
                    String fieldType = field.getType().getSimpleName();
                    Object parsedFieldValue = parseFieldValue(fieldType, fieldValue);
                    try {
                        field.set(editGame, parsedFieldValue);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return editGame;
    }

    private Object parseFieldValue(String fieldType, String fieldValue) {
        switch (fieldType) {
            case "String":
                return fieldValue;
            case "Double":
                return Double.valueOf(fieldValue);
            case "BigDecimal":
                return new BigDecimal(fieldValue);
            case "Date":
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                Date date = null;
                try {
                    date = dateFormat.parse(fieldValue);
                } catch (ParseException e) {
                    throw new IllegalArgumentException("Invalid release date format!");
                }

                return date;
            default:
                return null;
        }
    }
}
