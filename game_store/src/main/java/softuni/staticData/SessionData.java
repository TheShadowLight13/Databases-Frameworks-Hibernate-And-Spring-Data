package softuni.staticData;

import softuni.models.bindingModels.user.LoggedInUser;

public class SessionData {

    public static final String currentPath = System.getProperty("user.dir");

    private static LoggedInUser loggedInUser;

    public static LoggedInUser getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(LoggedInUser loggedInUser) {
        SessionData.loggedInUser = loggedInUser;
    }
}
