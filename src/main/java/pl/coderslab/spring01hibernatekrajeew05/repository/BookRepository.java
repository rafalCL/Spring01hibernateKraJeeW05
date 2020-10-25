package pl.coderslab.spring01hibernatekrajeew05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;
import pl.coderslab.spring01hibernatekrajeew05.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(long categoryId);
    List<Book> findAllByCategoryName(String name);
    @Query("SELECT b FROM Book b WHERE b.title = ?1")
    List<Book> findAllMyFavouriteBooksByTitle(String title);
    @Query("SELECT b FROM Book b WHERE b.category = :cat")
    List<Book> findAllBooksBelongingToCategory(@Param("cat") Category category);
}
