package pl.coderslab.web;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.dao.StudentDao;
import pl.coderslab.dao.StudentGroupDao;
import pl.coderslab.entity.Student;
import pl.coderslab.entity.StudentGroup;

import java.util.Arrays;
import java.util.List;

@Controller
public class StudentController {
    private final StudentGroupDao studentGroupDao;
    private final StudentDao studentDao;

    public StudentController(StudentGroupDao studentGroupDao, StudentDao studentDao) {
        this.studentGroupDao = studentGroupDao;
        this.studentDao = studentDao;
    }
    @ModelAttribute("studentGroups")
    public List<StudentGroup> getGroups(){
        return studentGroupDao.getAll();
    }


    @RequestMapping(value = "/register",method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        Student student = new Student();
        student.setFirstName("Arek");
        model.addAttribute("student", student);
        return "student/form"; }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processForm(@ModelAttribute Student student, Model model) {
        model.addAttribute("student", student);
        studentDao.save(student);
        return "student/success";
    }

    @ModelAttribute("languages")
    public List<String> checkOptions() {
        System.out.println("COŚ Z MODEL ATTRIBITE");
        String a[] = new String[] {"java", "php", "ruby", "python"};
        return Arrays.asList(a);
    }
}
