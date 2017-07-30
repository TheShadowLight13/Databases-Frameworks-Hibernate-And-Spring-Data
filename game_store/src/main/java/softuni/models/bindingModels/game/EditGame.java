package softuni.models.bindingModels.game;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EditGame implements Serializable{

    private static final long serialVersionUID = 598397612586974136L;

    private Long id;

    private String title;

    private String trailerURL;

    private String imageThumbnail;

    private Double size;

    private BigDecimal price;

    private String description;

    private Date releasedDate;

    public EditGame() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Size(min = 3, max = 100, message = "Title must be between 3 and 100 symbols!")
    @Pattern(regexp = "^[A-Z].*$", message = "Title must start with uppercase letter!")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Size(min = 11, max = 11, message = "Trailer must be exactly 11 symbols!")
    public String getTrailerURL() {
        return this.trailerURL;
    }

    public void setTrailerURL(String trailerURL) {
        this.trailerURL = trailerURL;
    }

    @Pattern(regexp = "((https:\\/\\/)|(http:\\/\\/))(.+)", message = "Incorrect image format!")
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

    @DecimalMin(value = "0.00", message = "Price must be positive!")
    @Digits(integer = 1000, fraction = 2)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Size(min = 20, message = "Description must be min 20 symbols!")
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
}
