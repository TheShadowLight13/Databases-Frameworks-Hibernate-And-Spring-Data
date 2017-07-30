package softuni.services.api;

import softuni.entities.Game;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.viewModels.game.GameDetailsView;
import softuni.models.viewModels.game.GameView;

import java.util.List;

public interface GameService {

    void add(AddGame addGame);

    EditGame findById(Long id);

    void editGame(EditGame editGame);

    void deleteById(Long id);

    List<GameView> findAll();

    GameDetailsView findGameDetailsByTitle(String title);

    EditGame findByTitle(String title);
}
