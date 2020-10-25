package pl.coderslab.spring01hibernatekrajeew05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
