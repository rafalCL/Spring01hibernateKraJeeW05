package pl.coderslab.spring01hibernatekrajeew05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew05.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew05.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;

@Controller
@RequestMapping("/book")
public class BookController {
    private PublisherDao publisherDao;
    private BookDao bookDao;

    @Autowired
    public BookController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/addbookwp")
    @ResponseBody
    public String addBookWithPublisher(){
        Publisher publisher = new Publisher();
        publisher.setName("PWN");
        publisherDao.save(publisher);

        Book book = new Book()
                .setTitle("Thinking in C++")
                .setDescription("Bardzo dobra książka o programowaniu")
                .setPublisher(publisher);

        bookDao.save(book);

        return "added book id="+book.getId()+
               " with publisher id="+publisher.getId();
    }

    @GetMapping("/addanotherwp")
    @ResponseBody
    public String addAnotherBookWithPublisher(){
        Publisher publisher = publisherDao.findById(1l);

        Book book = new Book();

        book.setTitle("Thinking in Java");
        book.setDescription("Ciekawa pozycja");
        book.setPublisher(publisher);

        bookDao.save(book);

        return "added book id="+book.getId()+
                " with publisher id="+publisher.getId();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String getBookById(@PathVariable long id){
        Book b = bookDao.findById(id);

        return b.toString();
    }
}
