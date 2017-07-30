package softuni.models.viewModels.game;

import java.math.BigDecimal;
import java.util.Date;

public class GameDetailsView {

    private String title;

    private String trailerURL;

    private String imageThumbnail;

    private Double size;

    private BigDecimal price;

    private String description;

    private Date releasedDate;

    public GameDetailsView() {
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailerURL() {
        return this.trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    public String getImageThumbnail() {
        return this.imageThumbnail;
    }

    public void setImageThumbnail(String imageThumbnail) {
        this.imageThumbnail = imageThumbnail;
    }

    public Double getSize() {
        return this.size;
    }

    public void setSize(Double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getReleasedDate() {
        return this.releasedDate;
    }

    public void setReleasedDate(Date releasedDate) {
        this.releasedDate = releasedDate;
    }

    @Override
    public String toString() {
        StringBuilder gameInfo = new StringBuilder();
        gameInfo.append(String.format("Title: %s%n", this.getTitle()));
        gameInfo.append(String.format("Price: %s%n", this.getPrice()));
        gameInfo.append(String.format("Size: %s%n", this.getSize()));
        gameInfo.append(String.format("Trailer: %s%n", this.getTrailerURL()));
        gameInfo.append(String.format("Thumbnail URL: %s%n", this.getImageThumbnail()));
        gameInfo.append(String.format("Description: %s%n", this.getDescription()));
        gameInfo.append(String.format("Release date: %s", this.getReleasedDate()));
        return gameInfo.toString();
    }
}
