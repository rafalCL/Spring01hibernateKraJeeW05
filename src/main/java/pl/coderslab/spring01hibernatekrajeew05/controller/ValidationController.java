package pl.coderslab.spring01hibernatekrajeew05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.spring01hibernatekrajeew05.dao.BookDao;
import pl.coderslab.spring01hibernatekrajeew05.entity.Book;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Set;

@Controller
@RequestMapping("/validation")
public class ValidationController {
    private Validator validator;
    private BookDao bookDao;

    @Autowired
    public ValidationController(Validator validator, BookDao bookDao) {
        this.validator = validator;
        this.bookDao = bookDao;
    }

    @GetMapping(value = "/example1", produces = "text/html;charset=UTF-8;")
    @ResponseBody
    public String example1(){
        Book b = new Book();

        Set<ConstraintViolation<Book>> violations = this.validator.validate(b);

        String msg;

        if (violations.isEmpty()) {
            bookDao.save(b);
            msg = "Zapisano: " + b.toString();
        } else {
            msg = "Błędy walidacji:<br>\r\n";
            for (ConstraintViolation<Book> v : violations){
                msg += v.getPropertyPath() + " : " + v.getMessage() + "<br>\r\n";
            }
        }

        return msg;
    }
}
