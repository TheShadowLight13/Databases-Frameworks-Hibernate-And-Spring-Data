package softuni.services.api;

import org.springframework.data.repository.query.Param;
import softuni.entities.Game;
import softuni.entities.User;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.bindingModels.user.LoggedInUser;
import softuni.models.bindingModels.user.RegisterUser;
import softuni.models.viewModels.game.GameView;

import java.util.List;
import java.util.Set;

public interface UserService{

    void register(RegisterUser registerUser);

    RegisterUser findByEmail(String email);

    LoggedInUser logIn(String email, String password);

    Set<GameView> getAllBoughtGamesView(Long userId);

    void addGameToShoppingCard(EditGame editGame);

    void removeFromShoppingCart(EditGame editGame);

    String buyGames();
}
