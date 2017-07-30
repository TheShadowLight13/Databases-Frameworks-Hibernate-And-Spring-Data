package softuni.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "games")
public class Game {

    private Long id;

    private String title;

    private String trailerURL;

    private String imageThumbnail;

    private Double size;

    private BigDecimal price;

    private String description;

    private Date releasedDate;

    public Game(String title, Double size, BigDecimal price) {
        this.title = title;
        this.size = size;
        this.price = price;
    }

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "title", nullable = false)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "trailer_url")
    public String getTrailerURL() {
        return this.trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    @Column(name = "image_thumbnail_url")
    public String getImageThumbnail() {
        return this.imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    @Basic
    public Double getSize() {
        return this.size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    @Column(name = "price", nullable = false)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "released_date")
    public Date getReleasedDate() {
        return this.releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        return this.getTitle();
    }
}
