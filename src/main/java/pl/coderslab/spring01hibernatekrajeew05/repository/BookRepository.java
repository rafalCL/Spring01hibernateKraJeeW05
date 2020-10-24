package pl.coderslab.spring01hibernatekrajeew05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
