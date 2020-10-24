package pl.coderslab.spring01hibernatekrajeew05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew05.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrajeew05.entity.Publisher;

import javax.transaction.Transactional;

@Controller
@RequestMapping("/publisher")
public class PublisherController {
    private PublisherDao publisherDao;

    @Autowired
    public PublisherController(PublisherDao publisherDao) {
        this.publisherDao = publisherDao;
    }

    @GetMapping("/books/{publisherId}")
    @ResponseBody
    @Transactional
    public String getBookById(@PathVariable long publisherId){
//        Publisher p = publisherDao.findByIdWithBooks(publisherId);
        Publisher p = publisherDao.findById(publisherId);
        p = publisherDao.readBooks(p);

        return p.getBooks().toString();
    }
}
