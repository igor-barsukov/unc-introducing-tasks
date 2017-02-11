package companydb.controller;

import companydb.model.Employee;
import companydb.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired(required = true)
    @Qualifier(value = "employeeService")
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(value = "employees", method = RequestMethod.GET)
    public String listEmployee(Model model){
        model.addAttribute("employee", new Employee());
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employees";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee){
            this.employeeService.addEmployee(employee);
        return "redirect:/employees";
    }

    @RequestMapping("/remove/{id}")
    public String removeEmployee(@PathVariable("id") int id){
        this.employeeService.removeEmployee(id);
        return "redirect:/employees";
    }
    @RequestMapping("edit/{id}")
     public String editEmployee(@PathVariable("id") int id, Model model){
        model.addAttribute("employee", this.employeeService.getEmployeeById(id));
        model.addAttribute("listEmployees", this.employeeService.listEmployee());
        return "employees";
    }
}
