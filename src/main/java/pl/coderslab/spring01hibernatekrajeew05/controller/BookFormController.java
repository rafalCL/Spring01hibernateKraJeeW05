package pl.coderslab.spring01hibernatekrajeew05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.spring01hibernatekrajeew05.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew05.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;

import java.util.List;

@Controller
@RequestMapping("/bookform")
public class BookFormController {
    private PublisherDao publisherDao;
    private BookDao bookDao;

    @Autowired
    public BookFormController(PublisherDao publisherDao, BookDao bookDao) {
        this.publisherDao = publisherDao;
        this.bookDao = bookDao;
    }

    @GetMapping("/addform")
    public String addForm(Model m){
        m.addAttribute("book", new Book());

        return "book/add-form";
    }

    @PostMapping("/addform")
    public String addFormPost(@ModelAttribute Book book, Model m){
        this.bookDao.save(book);
        m.addAttribute("book", book);

        return "book/show";
    }

    @ModelAttribute("publishers")
    public List<Publisher> publishers(){
        return publisherDao.findAll();
    }

}
