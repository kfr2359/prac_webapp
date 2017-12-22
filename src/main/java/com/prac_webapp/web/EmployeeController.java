package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.*;
import com.prac_webapp.util.editors.JobEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class EmployeeController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Job.class, new JobEditor());
    }

    @RequestMapping("/employee_show")
    public String employeeShowPage(@RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        EmployeeEmailDAO emailDAO = DAOFactory.getEmployeeEmailDAO();
        EmployeePhoneDAO phoneDAO = DAOFactory.getEmployeePhoneDAO();
        JobDAO jobDAO = DAOFactory.getJobDAO();

        Employee employee = employeeDAO.getById(id);
        List<EmployeeEmail> emailList = (List<EmployeeEmail>) emailDAO.getByEmployee(employee);
        List<EmployeePhone> phoneList = (List<EmployeePhone>) phoneDAO.getByEmployee(employee);
        List<Job> jobList = (List<Job>) jobDAO.getAll();

        map.put("employee", employee);
        map.put("emailList", emailList);
        map.put("email", new EmployeeEmail());
        map.put("phoneList", phoneList);
        map.put("phone", new EmployeePhone());
        map.put("ccEmail", new EmployeeEmail());
        map.put("ccPhone", new EmployeePhone());
        map.put("jobList", jobList);

        return "employee_show";
    }

    @RequestMapping("/modifyEmployee")
    public String employeeModifyPage(@ModelAttribute("employee") Employee employee,
                                     @RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        Employee e = employeeDAO.getById(id);
        e.setName(employee.getName());
        e.setAddress(employee.getAddress());
        e.setEducation(employee.getEducation());
        e.setJob(employee.getJob());

        employeeDAO.update(e);

        return "redirect:/employee_show?id="+Integer.toString(id);
    }

    @RequestMapping(value = "/modify_e_email", method = RequestMethod.POST)
    public String employeeModifyEmail(@ModelAttribute("ccEmail") EmployeeEmail ccEmail,
                                      @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeeEmailDAO emailDAO = DAOFactory.getEmployeeEmailDAO();
        EmployeeEmail email = emailDAO.getById(id);
        email.setEmail(ccEmail.getEmail());
        emailDAO.update(email);

        return "redirect:/employee_show?id="+Integer.toString(email.getEmployee().getId());
    }

    @RequestMapping(value = "/modify_e_phone", method = RequestMethod.POST)
    public String employeeModifyPhone(@ModelAttribute("ccPhone") EmployeePhone ccPhone,
                                           @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeePhoneDAO phoneDAO = DAOFactory.getEmployeePhoneDAO();
        EmployeePhone phone = phoneDAO.getById(id);
        phone.setPhone(ccPhone.getPhone());
        phoneDAO.update(phone);

        return "redirect:/employee_show?id="+Integer.toString(phone.getEmployee().getId());
    }

    @RequestMapping("/delete_e_email")
    public String employeeDeleteEmail(@RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeeEmailDAO emailDAO = DAOFactory.getEmployeeEmailDAO();
        EmployeeEmail email = emailDAO.getById(id);
        Employee Employee = email.getEmployee();

        emailDAO.delete(email);

        return "redirect:/employee_show?id="+Integer.toString(Employee.getId());
    }

    @RequestMapping("/delete_e_phone")
    public String employeeDeletePhone(@RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeePhoneDAO phoneDAO = DAOFactory.getEmployeePhoneDAO();
        EmployeePhone phone = phoneDAO.getById(id);
        Employee Employee = phone.getEmployee();

        phoneDAO.delete(phone);

        return "redirect:/employee_show?id="+Integer.toString(Employee.getId());
    }

}
