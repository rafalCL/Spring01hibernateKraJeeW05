package pl.coderslab.spring01hibernatekrajeew05.entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(min = 5)
    private String title;
    @Range(min = 1, max = 10)
    private int rating;
    @Size(max = 600)
    private String description;
    @ManyToOne
    @NotNull(message = "Oh, Dear, this must NOT be null")
    private Publisher publisher;
    @Min(1)
    private int pages;

    public Book(){

    }

    public long getId() {
        return id;
    }

    public Book setId(long id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Book setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getRating() {
        return rating;
    }

    public Book setRating(int rating) {
        this.rating = rating;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Book setDescription(String description) {
        this.description = description;
        return this;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public Book setPublisher(Publisher publisher) {
        this.publisher = publisher;
        return this;
    }

    public int getPages() {
        return pages;
    }

    public Book setPages(int pages) {
        this.pages = pages;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", publisher=" + publisher +
                ", pages=" + pages +
                '}';
    }
}
