package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Game;
import softuni.entities.User;
import softuni.enums.Role;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.bindingModels.user.RegisterUser;
import softuni.models.viewModels.game.GameView;
import softuni.repositories.UserRepository;
import softuni.services.api.UserService;
import softuni.staticData.SessionData;
import softuni.utils.ModelMapperUtils;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void register(RegisterUser registerUser) {
        User user = ModelMapperUtils.getInstance().map(registerUser, User.class);
        if (this.userRepository.findAll().size() == 0) {
            user.setRole(Role.ADMINISTRATOR);
        }else {
            user.setRole(Role.USER);
        }

        this.userRepository.saveAndFlush(user);
    }

    @Override
    public RegisterUser findByEmail(String email) {
        User user = this.userRepository.findByEmail(email);
        if (user != null) {
            return ModelMapperUtils.getInstance().map(user, RegisterUser.class);
        }

        return null;
    }

    @Override
    public LoggedInUser logIn(String email, String password) {
        User user = this.userRepository.findByEmailAndPassword(email, password);
        LoggedInUser loggedInUser = null;
        if (user != null) {
            loggedInUser = ModelMapperUtils.getInstance().map(user, LoggedInUser.class);
        }

        return loggedInUser;
    }

    @Override
    public Set<GameView> getAllBoughtGamesView(Long userId) {
        Set<Game> boughtGames = this.userRepository.getAllBoughtGames(userId);
        Set<GameView> boughtGamesView = new HashSet<>();

        for (Game boughtGame : boughtGames) {
            GameView gameView = ModelMapperUtils.getInstance()
                    .map(boughtGame, GameView.class);
            boughtGamesView.add(gameView);
        }

        return boughtGamesView;
    }

    @Override
    public void addGameToShoppingCard(EditGame editGame) {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        User user = this.userRepository.findOne(loggedInUser.getId());
        Game gameToBeBought = ModelMapperUtils.getInstance().map(editGame, Game.class);
        user.addGameToShoppingCart(gameToBeBought);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public void removeFromShoppingCart(EditGame editGame) {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        User user = this.userRepository.findOne(loggedInUser.getId());
        Game gameToBeRemoved = ModelMapperUtils.getInstance().map(editGame, Game.class);
        user.removeGameFromShoppingCart(gameToBeRemoved);
        this.userRepository.saveAndFlush(user);
    }

    @Override
    public String buyGames() {
        LoggedInUser loggedInUser = SessionData.getLoggedInUser();
        User user = this.userRepository.findOne(loggedInUser.getId());

        Set<Game> gamesInShoppingCart = user.getShoppingCartGames();
        if (gamesInShoppingCart == null || gamesInShoppingCart.isEmpty()) {
            throw new IllegalArgumentException("You do not have games in shopping cart!");
        }

        StringBuilder boughtGamesInfo = new StringBuilder();
        boughtGamesInfo.append("Successfully bought games:\n");
        for (Game game : gamesInShoppingCart) {
            boughtGamesInfo.append(String.format("%s%n", game));
        }

        if (boughtGamesInfo.length() > 0) {
            boughtGamesInfo.setLength(boughtGamesInfo.length() - 1);
        }

        user.buyGames();
        return boughtGamesInfo.toString();
    }
}
