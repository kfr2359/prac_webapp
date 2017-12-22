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
public class ClientContactModifyController {
    @RequestMapping("/clientcontact_modify")
    public String clientContactModifyPage(@RequestParam(value="id") Integer id, Map<String, Object> map) {
        ClientContactDAO clientContactDAO = DAOFactory.getClientContactDAO();
        ClientContact clientContact = clientContactDAO.getById(id);
        map.put("clientContact", clientContact);

        return "clientcontact_modify";
    }

    @RequestMapping(value = "/modifyClientContact", method = RequestMethod.POST)
    public String clientContactModify(@ModelAttribute("clientContact") ClientContact clientContact,
                                      @RequestParam(value = "id") Integer id, Map<String, Object> map) {
        ClientContactDAO ccDAO = DAOFactory.getClientContactDAO();
        ClientContact cc = ccDAO.getById(id);
        cc.setName(clientContact.getName());
        cc.setAddress(clientContact.getAddress());
        ccDAO.update(cc);

        return "redirect:/clientcontact_show?id="+Integer.toString(id);
    }

}
