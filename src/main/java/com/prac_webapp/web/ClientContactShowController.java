package com.prac_webapp.web;

import com.prac_webapp.DAO.*;
import com.prac_webapp.logic.Client;
import com.prac_webapp.logic.ClientContact;
import com.prac_webapp.logic.ClientContactEmail;
import com.prac_webapp.logic.ClientContactPhone;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class ClientContactShowController {
    @RequestMapping("/clientcontact_show")
    public String clientContactShowPage(@RequestParam(value="id") Integer id, Map<String, Object> map) {
        ClientContactDAO clientContactDAO = DAOFactory.getClientContactDAO();
        ClientContactEmailDAO emailDAO = DAOFactory.getClientContactEmailDAO();
        ClientContactPhoneDAO phoneDAO = DAOFactory.getClientContactPhoneDAO();
        ClientContact clientContact = clientContactDAO.getById(id);
        List<ClientContactEmail> emailList = (List<ClientContactEmail>) emailDAO.getByClientContact(clientContact);
        List<ClientContactPhone> phoneList = (List<ClientContactPhone>) phoneDAO.getByClientContact(clientContact);
        map.put("clientContact", clientContact);
        map.put("emailList", emailList);
        map.put("email", new ClientContactEmail());
        map.put("phoneList", phoneList);
        map.put("phone", new ClientContactPhone());
        map.put("ccEmail", new ClientContactEmail());
        map.put("ccPhone", new ClientContactPhone());

        return "clientcontact_show";
    }

    @RequestMapping(value = "/modify_cc_email", method = RequestMethod.POST)
    public String clientContactModifyEmail(@ModelAttribute("ccEmail") ClientContactEmail ccEmail,
                                           @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactEmailDAO emailDAO = DAOFactory.getClientContactEmailDAO();
        ClientContactEmail email = emailDAO.getById(id);
        email.setEmail(ccEmail.getEmail());
        emailDAO.update(email);

        return "redirect:/clientcontact_show?id="+Integer.toString(email.getContact().getId());
    }

    @RequestMapping(value = "/modify_cc_phone", method = RequestMethod.POST)
    public String clientContactModifyPhone(@ModelAttribute("ccPhone") ClientContactPhone ccPhone,
                                           @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactPhoneDAO PhoneDAO = DAOFactory.getClientContactPhoneDAO();
        ClientContactPhone phone = PhoneDAO.getById(id);
        phone.setPhone(ccPhone.getPhone());
        PhoneDAO.update(phone);

        return "redirect:/clientcontact_show?id="+Integer.toString(phone.getContact().getId());
    }
    
    @RequestMapping("/delete_cc_email")
    public String clientContactDeleteEmail(@RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactEmailDAO emailDAO = DAOFactory.getClientContactEmailDAO();
        ClientContactEmail email = emailDAO.getById(id);
        ClientContact clientContact = email.getContact();

        emailDAO.delete(email);

        return "redirect:/clientcontact_show?id="+Integer.toString(clientContact.getId());
    }

    @RequestMapping("/delete_cc_phone")
    public String clientContactDeletePhone(@RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactPhoneDAO phoneDAO = DAOFactory.getClientContactPhoneDAO();
        ClientContactPhone phone = phoneDAO.getById(id);
        ClientContact clientContact = phone.getContact();

        phoneDAO.delete(phone);

        return "redirect:/clientcontact_show?id="+Integer.toString(clientContact.getId());
    }
}
