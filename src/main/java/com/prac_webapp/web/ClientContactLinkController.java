package com.prac_webapp.web;

import com.prac_webapp.DAO.ClientContactDAO;
import com.prac_webapp.DAO.ClientContactEmailDAO;
import com.prac_webapp.DAO.ClientContactPhoneDAO;
import com.prac_webapp.DAO.DAOFactory;
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
public class ClientContactLinkController {
    @RequestMapping("/clientcontactlink_add")
    public String clientContactLinkAddShowPage(@RequestParam(value="id") Integer id, Map<String, Object> map) {
        ClientContactDAO clientContactDAO = DAOFactory.getClientContactDAO();
        ClientContact clientContact = clientContactDAO.getById(id);
        map.put("clientContact", clientContact);
        map.put("ccEmail", new ClientContactEmail());
        map.put("ccPhone", new ClientContactPhone());

        return "clientcontactlink_add";
    }

    @RequestMapping(value = "/add_cc_email", method = RequestMethod.POST)
    public String clientContactAddEmail(@ModelAttribute("ccEmail") ClientContactEmail ccEmail,
                                        @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactEmailDAO emailDAO = DAOFactory.getClientContactEmailDAO();
        ClientContactDAO ccDAO = DAOFactory.getClientContactDAO();
        ccEmail.setContact(ccDAO.getById(id));
        emailDAO.add(ccEmail);

        return "redirect:/clientcontact_show?id="+Integer.toString(id);
    }

    @RequestMapping(value = "/add_cc_phone", method = RequestMethod.POST)
    public String clientContactAddPhone(@ModelAttribute("ccPhone") ClientContactPhone ccPhone,
                                        @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactPhoneDAO phoneDAO = DAOFactory.getClientContactPhoneDAO();
        ClientContactDAO ccDAO = DAOFactory.getClientContactDAO();
        ccPhone.setContact(ccDAO.getById(id));
        phoneDAO.add(ccPhone);

        return "redirect:/clientcontact_show?id="+Integer.toString(id);
    }

}
