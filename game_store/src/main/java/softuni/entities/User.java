package softuni.entities;

import softuni.enums.Role;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    private Long id;

    private String email;

    private String password;

    private String fullName;

    private Role role;

    private Set<Game> shoppingCartGames;

    private Set<Game> boughtGames;

    public User(String email, String password, String fullName) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.shoppingCartGames = new HashSet<>();
        this.boughtGames = new HashSet<>();
    }

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "email", nullable = false, unique = true)
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "full_name")
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @ManyToMany
    @JoinTable(name = "orders", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"),
            foreignKey = @ForeignKey(name = "fk_orders_users"),
            inverseForeignKey = @ForeignKey(name = "fk_orders_games"))
    public Set<Game> getBoughtGames() {
        return this.boughtGames;
    }

    public void setBoughtGames(Set<Game> boughtGames) {
        this.boughtGames = boughtGames;
    }

    @ManyToMany
    @JoinTable(name = "users_cart_games",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "game_id"),
            foreignKey = @ForeignKey(name = "fk_users_cart_games_users"),
            inverseForeignKey = @ForeignKey(name = "fk_users_cart_games_games"))
    public Set<Game> getShoppingCartGames() {
        return this.shoppingCartGames;
    }

    public void setShoppingCartGames(Set<Game> shoppingCartGames) {
        this.shoppingCartGames = shoppingCartGames;
    }

    @Transient
    public void addGameToShoppingCart(Game game) {
        if (this.shoppingCartGames == null) {
            this.shoppingCartGames = new HashSet<>();
            this.shoppingCartGames.add(game);
            return;
        }

        boolean isGameAlreadyBought = this.boughtGames.stream()
                .anyMatch(g -> g.getId().compareTo(game.getId()) == 0);
        if (isGameAlreadyBought) {
            throw new IllegalArgumentException("Game is already bought!");
        }

        boolean isGameAlreadyInShoppingCart = this.shoppingCartGames.stream()
                .anyMatch(g -> g.getId().compareTo(game.getId()) == 0);
        if (isGameAlreadyInShoppingCart) {
            throw new IllegalArgumentException("Game is already in shopping cart!");
        }

        this.shoppingCartGames.add(game);
    }

    @Transient
    public void removeGameFromShoppingCart(Game game) {
        if (this.shoppingCartGames == null || this.shoppingCartGames.isEmpty()) {
            throw new IllegalArgumentException("Game is not in shopping cart!");
        }

        boolean isGameInShoppingCart = this.shoppingCartGames.stream()
                .anyMatch(g -> g.getId().compareTo(game.getId()) == 0);

        if (!isGameInShoppingCart) {
            throw new IllegalArgumentException("Game is not in shopping cart!");
        }

        this.shoppingCartGames.removeIf(g -> g.getId().compareTo(game.getId()) == 0);
    }

    @Transient
    public void buyGames(){
        if (this.boughtGames == null) {
            this.boughtGames = new HashSet<>();
        }

        this.boughtGames.addAll(this.shoppingCartGames);
        this.shoppingCartGames.clear();
    }
}
