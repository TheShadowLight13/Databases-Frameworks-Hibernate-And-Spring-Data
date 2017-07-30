package softuni.io.interpreters;


import softuni.io.commands.Executable;

import java.lang.reflect.InvocationTargetException;

public interface Interpreter {

    String interpretCommand(String input) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException;

    Executable parseCommand(String commandName, String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
