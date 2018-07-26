package pl.coderslab.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.entity.ValidatedBook;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class ValidationController {

    @Autowired
    Validator validator;

    @GetMapping("/validate")
    public void validateBook(){
        ValidatedBook validatedBook = new ValidatedBook();
        validatedBook.setTitle("1");
        List<String> errros = new ArrayList<>();
        Set<ConstraintViolation<ValidatedBook>> validate = validator.validate(validatedBook);



        for (ConstraintViolation<ValidatedBook> validatedBookConstraintViolation : validate) {

            errros.add(validatedBookConstraintViolation.getPropertyPath() + " " + validatedBookConstraintViolation.getMessage() );
        }


    }
}
