package pl.coderslab.spring01hibernatekrajeew05.dao;

import org.springframework.stereotype.Repository;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

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

    public List<Book> findAll() {
        Query q = em.createQuery("SELECT b FROM Book b");
        return q.getResultList();
    }

    public List<Book> findByRatingGT(int rating) {
        Query q = em.createQuery("SELECT b FROM Book b WHERE b.rating >= :minRating");
        q.setParameter("minRating", rating);

        return q.getResultList();
    }
}
