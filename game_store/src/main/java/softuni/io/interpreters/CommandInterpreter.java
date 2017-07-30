package softuni.io.interpreters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import softuni.io.commands.Executable;
import softuni.services.api.GameService;
import softuni.services.api.UserService;

import javax.transaction.Transactional;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Component
@Transactional
public class CommandInterpreter implements Interpreter {

    private static final String COMMANDS_PACKAGE = "softuni.io.commands.";
    private static final String COMMANDS_SUFFIX = "Command";

    private final UserService userService;

    private final GameService gameService;

    @Autowired
    public CommandInterpreter(UserService userService, GameService gameService) {
        this.userService = userService;
        this.gameService = gameService;
    }

    @Override
    public String interpretCommand(String input) throws
            ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InstantiationException, InvocationTargetException {
        String[] args = input.split("\\|");
        if (args[0].length() == 1) {
            throw new IllegalArgumentException("Invalid command!");
        }

        String commandName = args[0];
        Executable exe = this.parseCommand(commandName, args);
        return exe.execute();
    }

    @Override
    public Executable parseCommand(String commandName, String[] args)
            throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Executable exe = null;
        String className = commandName + COMMANDS_SUFFIX;
        try {
            Class<Executable> exeClass =
                    (Class<Executable>) Class.forName(COMMANDS_PACKAGE + className);
            Constructor<Executable> exeCtor = exeClass
                    .getConstructor(String[].class, UserService.class, GameService.class);
            exe = exeCtor.newInstance(args, this.userService, this.gameService);
        } catch (Throwable e) {
            throw new IllegalArgumentException("Command is not exist!");
        }

        return exe;
    }
}
