package pl.coderslab.spring01hibernatekrajeew05.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class BookDao {
    @PersistenceContext
    private EntityManager em;

    public void save(Book book){
        em.persist(book);
    }

    public Book findById(long id) {
        return em.find(Book.class, id);
    }
}
