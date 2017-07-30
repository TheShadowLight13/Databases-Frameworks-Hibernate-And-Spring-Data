package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.entities.Game;
import softuni.models.bindingModels.game.EditGame;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{

    Game findByTitle(String title);
}
