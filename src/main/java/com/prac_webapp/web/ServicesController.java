package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.logic.Service;
import com.prac_webapp.logic.ServiceType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class ServicesController {
    @RequestMapping("/services")
    public String servicesPage(Map<String, Object> map) {
        ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
        List<Service>     services     = (List<Service>)     serviceDAO.getAll();

        map.put("service", new Service());
        map.put("servicesList", services);

        return "services";
    }

    @RequestMapping("/service_delete")
    public String serviceDeletePage(@RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
        Service s = serviceDAO.getById(id);
        serviceDAO.delete(s);

        return "redirect:/services";
    }
    @RequestMapping("/service_add")
    public String serviceAddPage(Map<String, Object> map) {
        ServiceDAO serviceDAO = DAOFactory.getServiceDAO();
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();

        Service s = new Service();
        s.setStartDate(new Date(0));
        s.setEndDate(new Date(100000));
        s.setCost(10);
        s.setClient(clientDAO.getAll().iterator().next());
        s.setType(stDAO.getAll().iterator().next());

        serviceDAO.add(s);

        return "redirect:/service_show?id="+ String.valueOf(s.getId());
    }
}
