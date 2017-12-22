package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.*;
import com.prac_webapp.util.HibernateUtil;
import com.prac_webapp.util.editors.ClientEditor;
import com.prac_webapp.util.editors.EmployeeEditor;
import com.prac_webapp.util.editors.JobEditor;
import com.prac_webapp.util.editors.ServiceTypeEditor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Controller
public class ServiceController {
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(ServiceType.class, new ServiceTypeEditor());
        binder.registerCustomEditor(Client.class, new ClientEditor());
        binder.registerCustomEditor(Employee.class, new EmployeeEditor());
    }

    @RequestMapping("/service_show")
    public String employeeShowPage(@RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        EmployeeDAO empDAO = DAOFactory.getEmployeeDAO();

        Service service = serviceDAO.getById(id);
        List<ServiceType> typeList = (List<ServiceType>) stDAO.getAll();
        List<Client> clientList = (List<Client>) clientDAO.getAll();
        List<Employee> employeeList = (List<Employee>) empDAO.getAll();

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.refresh(service);
        Hibernate.initialize(service.getEmployees());
        session.getTransaction().commit();

        map.put("service", service);
        map.put("typeList", typeList);
        map.put("clientList", clientList);
        map.put("employeeList", employeeList);

        return "service_show";
    }

    @RequestMapping("/modifyService")
    public String employeeModifyPage(@ModelAttribute("service") Service service,
                                     @RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
        Service s = serviceDAO.getById(id);

        s.setType(service.getType());
        s.setClient(service.getClient());
        s.setCost(service.getCost());
        s.setStartDate(service.getStartDate());
        s.setEndDate(service.getEndDate());
        s.setEmployees(service.getEmployees());

        serviceDAO.update(s);

        return "redirect:/service_show?id="+Integer.toString(id);
    }

}
