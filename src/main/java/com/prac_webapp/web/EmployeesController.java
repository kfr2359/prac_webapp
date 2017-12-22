package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.Employee;
import com.prac_webapp.logic.Service;
import com.prac_webapp.logic.ServiceType;
import com.prac_webapp.util.filters.EmployeeFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class EmployeesController {
    @RequestMapping("/employees")
    public String employeesPage(Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        List<Employee> employees = (List<Employee>) employeeDAO.getAll();

        EmployeeFilter employeeFilter = new EmployeeFilter();

        //clients
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        List<Client> clients = (List<Client>) clientDAO.getAll();

        employeeFilter.setClientsId(new ArrayList<String>());
        Iterator<Client> it = clients.iterator();
        while (it.hasNext()) {
            Client c = it.next();
            employeeFilter.getClientsId().add(Integer.toString(c.getId()));
        }

        //service types
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();
        List<ServiceType> serviceTypes = stDAO.getAll();

        employeeFilter.setServiceTypesId(new ArrayList<String>());
        Iterator<ServiceType> it2 = serviceTypes.iterator();
        while (it2.hasNext()) {
            ServiceType st = it2.next();
            employeeFilter.getServiceTypesId().add(Integer.toString(st.getId()));
        }

        //dates
        employeeFilter.setStartDate("01.01.1970");
        employeeFilter.setEndDate("01.01.2050");

        //finally
        map.put("employeeFilter", employeeFilter);

        map.put("serviceTypes", serviceTypes);
        map.put("clients", clients);
        map.put("employees", employees);

        map.put("client", new Client());
        map.put("employee", new Employee());
        map.put("serviceType", new ServiceType());

        return "employees";
    }

    @RequestMapping("/employee_add")
    public String employeeAddPage(Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        Employee emp = new Employee();
        emp.setName("ФИО");
        emp.setAddress("Адрес");
        emp.setEducation("Образование");
        emp.setJob(DAOFactory.getJobDAO().getAll().iterator().next());
        employeeDAO.add(emp);

        return "redirect:/employee_show?id="+ String.valueOf(emp.getId());
    }

    @RequestMapping("/employee_delete")
    public String employeeAddPage(@RequestParam("id") Integer id, Map<String, Object> map) {
        EmployeeDAO employeeDAO = DAOFactory.getEmployeeDAO();
        Employee e = employeeDAO.getById(id);
        employeeDAO.delete(e);

        return "redirect:/employees";
    }

    @RequestMapping(value = "/filterEmployees", method = RequestMethod.POST)
    public String employeesFilter(@ModelAttribute("employeeFilter") EmployeeFilter employeeFilter, Map<String, Object> map) {
        EmployeeDAO empDAO = DAOFactory.getEmployeeDAO();
        ServiceTypeDAO stDAO = DAOFactory.getServiceTypeDAO();
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        ServiceDAO sDAO = DAOFactory.getServiceDAO();

        //get chosen clients
        List<Client> lClients = new ArrayList<Client>();
        Iterator<String> it;
        if (employeeFilter.getClientsId() != null) {
            it = employeeFilter.getClientsId().iterator();
            while (it.hasNext()) {
                String strId = it.next();
                lClients.add(clientDAO.getById(Integer.valueOf(strId)));
            }
        }

        //get chosen service types
        List<ServiceType> lST = new ArrayList<ServiceType>();
        if (employeeFilter.getServiceTypesId() != null) {
            it = employeeFilter.getServiceTypesId().iterator();
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
        Set<Service> hsServicesC = new HashSet<Service>();
        Iterator<Client> itC = lClients.iterator();
        while (itC.hasNext()) {
            Client c = itC.next();
            hsServicesC.addAll(sDAO.getByClient(c));
        }

        //common part
        hsServicesC.retainAll(hsServicesST);

        //go throw to get services in period
        Set<Service> hsServicesRes = new HashSet<Service>();
        Iterator<Service> itS = hsServicesC.iterator();
        Date start = new Date(), end = new Date();
        try {
            start = new SimpleDateFormat("dd.MM.YYYY").parse(employeeFilter.getStartDate());
            end   = new SimpleDateFormat("dd.MM.YYYY").parse(employeeFilter.getEndDate());
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
        Set<Employee> employees = new HashSet<Employee>();
        itS = hsServicesRes.iterator();
        while (itS.hasNext()) {
            Service s = itS.next();
            employees.addAll(empDAO.getByService(s));
        }

        //return
        List<Client> clients = clientDAO.getAll();
        List<ServiceType> serviceTypes = stDAO.getAll();

        map.put("employeeFilter", employeeFilter);

        map.put("clients", clients);
        map.put("employees", employees);
        map.put("serviceTypes", serviceTypes);

        map.put("client", new Client());
        map.put("employee", new Employee());
        map.put("serviceType", new ServiceType());

        return "employees";
    }
}
