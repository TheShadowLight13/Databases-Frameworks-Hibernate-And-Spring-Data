package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import softuni.entities.Game;
import softuni.entities.User;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    User findByEmail(String email);

    User findByEmailAndPassword(String email, String password);

    @Query("SELECT u.boughtGames FROM User AS u WHERE u.id = :userId")
    Set<Game> getAllBoughtGames(@Param("userId") Long userId);
}
