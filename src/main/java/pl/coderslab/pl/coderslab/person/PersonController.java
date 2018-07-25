package pl.coderslab.pl.coderslab.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.dao.PersonDao;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validator;
import java.util.Set;

@Controller
public class PersonController {

    @Autowired
    Validator validator;

    @Autowired
    private PersonDao personDao;

    @GetMapping("/add-person")
    @ResponseBody
    public String addPerson() {
        Person person = new Person();
        person.setFirstName("Arek");

        Set<ConstraintViolation<Person>> validate = validator.validate(person);
        for (ConstraintViolation<Person> constraintViolation : validate) {
            System.out.println(
                      constraintViolation.getPropertyPath()
                              + " " +
                      constraintViolation.getMessage());
        }

        return "--added--";
    }

    @GetMapping("/add-person-form")
    public String addPersonForm(Model model){
        model.addAttribute("person", new Person());
        return "person/form";
    }
    @GetMapping("/person/list")
    @ResponseBody
    public String peopleList(Model model){
        return "--some list--";
    }

    @PostMapping("/add-person-form")
    public String addPersonPost(@Valid Person person, BindingResult result, Model model){
        if(result.hasErrors()){
            return "person/form";
        }

        personDao.save(person);
        return "redirect:/person/list";
    }


}
