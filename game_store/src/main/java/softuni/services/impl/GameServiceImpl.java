package softuni.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.entities.Game;
import softuni.models.bindingModels.game.AddGame;
import softuni.models.bindingModels.game.EditGame;
import softuni.models.viewModels.game.GameDetailsView;
import softuni.models.viewModels.game.GameView;
import softuni.repositories.GameRepository;
import softuni.services.api.GameService;
import softuni.utils.ModelMapperUtils;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class GameServiceImpl implements GameService{

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public void add(AddGame addGame) {
        Game game = ModelMapperUtils.getInstance().map(addGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public EditGame findById(Long id) {
        Game game = this.gameRepository.findOne(id);
        if (game == null) {
            throw new IllegalArgumentException("GameView is not exist!");
        }

        EditGame editGame = ModelMapperUtils.getInstance().map(game, EditGame.class);
        return editGame;
    }

    @Override
    public void editGame(EditGame editGame) {
        Game game = ModelMapperUtils.getInstance().map(editGame, Game.class);
        this.gameRepository.saveAndFlush(game);
    }

    @Override
    public void deleteById(Long id) {
        this.findById(id);
        this.gameRepository.delete(id);
    }

    @Override
    public List<GameView> findAll() {
        List<Game> games = this.gameRepository.findAll();
        List<GameView> gameViews = new ArrayList<>();

        for (Game game : games) {
           GameView gameView = ModelMapperUtils.getInstance().map(game, GameView.class);
           gameViews.add(gameView);
        }

        return gameViews;
    }

    @Override
    public GameDetailsView findGameDetailsByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title);
        if (game == null) {
            throw new IllegalArgumentException("Game is not exist!");
        }

        GameDetailsView gameDetailsView =
                ModelMapperUtils.getInstance().map(game, GameDetailsView.class);
        return gameDetailsView;
    }

    @Override
    public EditGame findByTitle(String title) {
        Game game = this.gameRepository.findByTitle(title);
        if (game == null) {
            throw new IllegalArgumentException("Game is not exist!");
        }

        EditGame editGame = ModelMapperUtils.getInstance().map(game, EditGame.class);
        return editGame;
    }
}
