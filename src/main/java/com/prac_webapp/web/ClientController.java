package com.prac_webapp.web;

import com.prac_webapp.DAO.ClientContactDAO;
import com.prac_webapp.DAO.ClientDAO;
import com.prac_webapp.DAO.DAOFactory;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.ClientContact;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ClientController {
    @RequestMapping("/client_show")
    public String clientShowPage(@RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        ClientContactDAO clientContactDAO = DAOFactory.getClientContactDAO();
        Client client = clientDAO.getById(id);
        List<ClientContact> clientContactList = (List<ClientContact>) clientContactDAO.getByClient(client);
        map.put("client", client);
        map.put("clientContactList", clientContactList);
        map.put("clientContact", new ClientContact());

        return "client_show";
    }

    @RequestMapping("/modifyClient")
    public String clientModifyPage(@ModelAttribute("client") Client client,
                                   @RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ClientDAO clientDAO = DAOFactory.getClientDAO();
        Client c = clientDAO.getById(id);
        c.setName(client.getName());
        clientDAO.update(c);

        return "redirect:/client_show?id="+Integer.toString(id);
    }

    @RequestMapping("/clientcontact_add")
    public String clientContactAdd(@RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ClientContactDAO ccDAO = DAOFactory.getClientContactDAO();
        ClientDAO cDAO = DAOFactory.getClientDAO();

        ClientContact clientContact = new ClientContact();
        clientContact.setName("ФИО");
        clientContact.setAddress("Адрес");
        clientContact.setClient(cDAO.getById(id));

        ccDAO.add(clientContact);

        return "redirect:/clientcontact_show?id="+Integer.toString(clientContact.getId());
    }

    @RequestMapping("/clientcontact_delete")
    public String clientContactDelete(@RequestParam(value="id", required = true) Integer id, Map<String, Object> map) {
        ClientContactDAO ccDAO = DAOFactory.getClientContactDAO();

        ClientContact clientContact = ccDAO.getById(id);
        Client c = clientContact.getClient();

        ccDAO.delete(clientContact);

        return "redirect:/client_show?id="+Integer.toString(c.getId());
    }
}
