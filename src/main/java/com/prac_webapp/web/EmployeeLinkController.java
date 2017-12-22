package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.logic.EmployeeEmail;
import com.prac_webapp.logic.EmployeePhone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class EmployeeLinkController {
    @RequestMapping("/employeelink_add")
    public String employeeLinkAddShowPage(@RequestParam(value="id") Integer id, Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        Employee employee = employeeDAO.getById(id);
        map.put("employee", employee);
        map.put("ccEmail", new EmployeeEmail());
        map.put("ccPhone", new EmployeePhone());

        return "employeelink_add";
    }

    @RequestMapping(value = "/add_e_email", method = RequestMethod.POST)
    public String employeeAddEmail(@ModelAttribute("ccEmail") EmployeeEmail ccEmail,
                                   @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeeEmailDAO emailDAO = DAOFactory.getEmployeeEmailDAO();
        EmployeeDAO ccDAO = DAOFactory.getEmployeeDAO();
        ccEmail.setEmployee(ccDAO.getById(id));
        emailDAO.add(ccEmail);

        return "redirect:/employee_show?id="+Integer.toString(id);
    }

    @RequestMapping(value = "/add_e_phone", method = RequestMethod.POST)
    public String employeeAddPhone(@ModelAttribute("ccPhone") EmployeePhone ccPhone,
                                   @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        EmployeePhoneDAO phoneDAO = DAOFactory.getEmployeePhoneDAO();
        EmployeeDAO ccDAO = DAOFactory.getEmployeeDAO();
        ccPhone.setEmployee(ccDAO.getById(id));
        phoneDAO.add(ccPhone);

        return "redirect:/employee_show?id="+Integer.toString(id);
    }

}
