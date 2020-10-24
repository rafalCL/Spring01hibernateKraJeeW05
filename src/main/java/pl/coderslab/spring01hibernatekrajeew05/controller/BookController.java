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
import pl.coderslab.spring01hibernatekrajeew05.entity.Category;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;
import pl.coderslab.spring01hibernatekrajeew05.repository.BookRepository;
import pl.coderslab.spring01hibernatekrajeew05.repository.CategoryRepository;

import javax.transaction.Transactional;
import java.util.List;


@Controller
@RequestMapping("/book")
@Transactional
public class BookController {
    private PublisherDao publisherDao;
    private BookDao bookDao;
    private BookRepository bookRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public BookController(PublisherDao publisherDao, BookDao bookDao, BookRepository bookRepository, CategoryRepository categoryRepository) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
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
//        Book b = bookDao.findById(id);
        Book b = this.bookRepository.getOne(id);

        return b.toString();
    }

    @GetMapping("/all")
    @ResponseBody
    public String getAll(){
//        List<Book> books = bookDao.findAll();
        List<Book> books = this.bookRepository.findAll();

        return books.toString();
    }

    @GetMapping("/byminrating/{minRating}")
    @ResponseBody
    public String getAll(@PathVariable int minRating){
        List<Book> books = bookDao.findByRatingGT(minRating);

        return books.toString();
    }

    @GetMapping("/bypubid/{pubId}")
    @ResponseBody
    public String getByPubId(@PathVariable long pubId){
        List<Book> books = bookDao.findByPublisherId(pubId);

        return books.toString();
    }

    @GetMapping("/title/{title}")
    @ResponseBody
    public String getByTitle(@PathVariable String title){
        Book b = this.bookRepository.findOneByTitle(title);

        return b.toString();
    }

    @GetMapping("/byCat/{catId}")
    @ResponseBody
    public String getByCategory(@PathVariable long catId){
        Category category = this.categoryRepository.getOne(catId);

        List<Book> books = this.bookRepository.findAllByCategory(category);

        return books.toString();
    }

    @GetMapping("/catId/{catId}")
    @ResponseBody
    public String getByCategoryId(@PathVariable long catId){
        List<Book> books = this.bookRepository.findAllByCategoryId(catId);

        return books.toString();
    }

    @GetMapping("/catName/{catName}")
    @ResponseBody
    public String getByCategoryId(@PathVariable String catName){
        List<Book> books = this.bookRepository.findAllByCategoryName(catName);

        return books.toString();
    }
}
