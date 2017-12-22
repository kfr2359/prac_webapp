package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.logic.Service;
import com.prac_webapp.logic.ServiceType;
import com.prac_webapp.util.filters.ClientFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ClientsController {
    @RequestMapping("/clients")
    public String clientsPage(Map<String, Object> map) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        List<Client> clients = (List<Client>) clientDAO.getAll();
        map.put("clientList", clients);

        ClientFilter clientFilter = new ClientFilter();

        //employees
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        List<Employee> employees = (List<Employee>) employeeDAO.getAll();
        map.put("employees", employees);

        clientFilter.setEmployeesId(new ArrayList<String>());
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()) {
            Employee emp = it.next();
            clientFilter.getEmployeesId().add(Integer.toString(emp.getId()));
        }

        //service types
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();
        List<ServiceType> serviceTypes = stDAO.getAll();
        map.put("serviceTypes", serviceTypes);

        clientFilter.setServiceTypesId(new ArrayList<String>());
        Iterator<ServiceType> it2 = serviceTypes.iterator();
        while (it2.hasNext()) {
            ServiceType st = it2.next();
            clientFilter.getServiceTypesId().add(Integer.toString(st.getId()));
        }

        //dates
        clientFilter.setStartDate("01.01.1970");
        clientFilter.setEndDate("01.01.2050");

        map.put("clientFilter", clientFilter);

        map.put("client", new Client());
        map.put("employee", new Employee());
        map.put("serviceType", new ServiceType());

        return "clients";
    }

    @RequestMapping("/client_add")
    public String clientAddPage(Map<String, Object> map) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        Client c = new Client();
        c.setName("ФИО");
        clientDAO.add(c);

        return "redirect:/client_show?id="+ String.valueOf(c.getId());
    }

    @RequestMapping("/client_delete")
    public String clientAddPage(@RequestParam("id") Integer id, Map<String, Object> map) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        Client c = clientDAO.getById(id);
        clientDAO.delete(c);

        return "redirect:/clients";
    }

    @RequestMapping(value = "/filterClients", method = RequestMethod.POST)
    public String clientsFilter(@ModelAttribute("clientFilter") ClientFilter clientFilter, Map<String, Object> map) {
        EmployeeDAO empDAO = DAOFactory.getEmployeeDAO();
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        ServiceDAO sDAO = DAOFactory.getServiceDAO();

        //get chosen employees
        List<Employee> lEmp = new ArrayList<Employee>();
        Iterator<String> it;
        if (clientFilter.getEmployeesId() != null) {
            it = clientFilter.getEmployeesId().iterator();
            while (it.hasNext()) {
                String strId = it.next();
                lEmp.add(empDAO.getById(Integer.valueOf(strId)));
            }
        }

        //get chosen service types
        List<ServiceType> lST = new ArrayList<ServiceType>();
        if (clientFilter.getServiceTypesId() != null) {
            it = clientFilter.getServiceTypesId().iterator();
            while (it.hasNext()) {
                String strId = it.next();
                lST.add(stDAO.getById(Integer.valueOf(strId)));
            }
        }

        //get services with chosen types
        Set<Service> hsServicesST = new HashSet<Service>();
        Iterator<ServiceType> itST = lST.iterator();
        while (itST.hasNext()) {
            ServiceType st = itST.next();
            hsServicesST.addAll(sDAO.getByServiceType(st));
        }

        //get service with chosen employees
        Set<Service> hsServicesEmp = new HashSet<Service>();
        Iterator<Employee> itEmp = lEmp.iterator();
        while (itEmp.hasNext()) {
            Employee emp = itEmp.next();
            hsServicesEmp.addAll(sDAO.getByEmployee(emp));
        }

        //common part
        hsServicesEmp.retainAll(hsServicesST);

        //go throw to get services in period
        Set<Service> hsServicesRes = new HashSet<Service>();
        Iterator<Service> itS = hsServicesEmp.iterator();
        Date start = new Date(), end = new Date();
        try {
            start = new SimpleDateFormat("dd.MM.YYYY").parse(clientFilter.getStartDate());
            end   = new SimpleDateFormat("dd.MM.YYYY").parse(clientFilter.getEndDate());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        while (itS.hasNext()) {
            Service s = itS.next();
            if (s.getStartDate().after(start) && s.getEndDate().before(end)) {
                hsServicesRes.add(s);
            }
        }

        //finally
        Set<Client> clients = new HashSet<Client>();
        itS = hsServicesRes.iterator();
        while (itS.hasNext()) {
            Service s = itS.next();
            clients.add(s.getClient());
        }

        //return
        List<Employee> employees = empDAO.getAll();
        List<ServiceType> serviceTypes = stDAO.getAll();

        map.put("clientList", clients);
        map.put("employees", employees);
        map.put("serviceTypes", serviceTypes);

        map.put("clientFilter", clientFilter);

        map.put("client", new Client());
        map.put("employee", new Employee());
        map.put("serviceType", new ServiceType());

        return "clients";
    }

}
