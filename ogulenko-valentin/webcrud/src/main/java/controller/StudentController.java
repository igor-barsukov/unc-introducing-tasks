package controller;

import dao.StudentDAO;
import dao.StudentJDBCTemplate;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by qwerty on 17.02.2017.
 */
@Controller
public class StudentController {
    @Autowired
    private StudentDAO StudentDAO;

    @RequestMapping(value = "/newContact", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Student newContact = new Student();
        model.addObject("contact", newContact);
        model.setViewName("StudentForm");
        return model;
    }

    @RequestMapping(value = "/saveContact", method = RequestMethod.POST)
    public ModelAndView saveContact(@ModelAttribute Student newStudent) {
        StudentDAO.saveOrUpdate(newStudent);
        return new ModelAndView("redirect:/students");
    }

    @RequestMapping(value="/students")
    public ModelAndView listStudents(ModelAndView model) throws IOException {
        List<Student> listStudents = StudentDAO.listStudents();
        model.addObject("listStudents", listStudents);
        model.setViewName("students");

        return model;
    }

    @RequestMapping(value = "/deleteContact", method = RequestMethod.GET)
    public ModelAndView deleteContact(HttpServletRequest request) {
        int studentID = Integer.parseInt(request.getParameter("id"));
        StudentDAO.delete(studentID);
        return new ModelAndView("redirect:/students");
    }

    @RequestMapping(value = "/editContact", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int studentID = Integer.parseInt(request.getParameter("id"));
        Student student = StudentDAO.get(studentID);
        ModelAndView model = new ModelAndView("StudentForm");
        model.addObject("contact", student);

        return model;
    }
}
