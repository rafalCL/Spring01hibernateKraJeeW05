package pl.coderslab.spring01hibernatekrajeew05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;
import pl.coderslab.spring01hibernatekrajeew05.entity.Category;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    Book findOneByTitle(String title);
    List<Book> findAllByCategory(Category category);
    List<Book> findAllByCategoryId(long categoryId);
    List<Book> findAllByCategoryName(String name);
}
