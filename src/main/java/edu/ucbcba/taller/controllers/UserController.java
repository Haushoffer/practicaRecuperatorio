package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.User;
import edu.ucbcba.taller.services.CompanyService;
import edu.ucbcba.taller.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by coreI7 on 30/04/2017.
 */
@Controller
public class UserController {

    private UserService userService;
    private CompanyService companyService;


    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
    @Autowired
    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.listAllUsers());
        return "users";
    }


    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String showUser(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "userShow";
    }


    @RequestMapping(value = "/user/delete/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id, Model model) {
        userService.deleteUser(id);
        return "users";
    }


    @RequestMapping(value = "/user/new", method = RequestMethod.GET)
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("usersList", userService.listAllUsers());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "userForm";
    }


    @RequestMapping("user/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        model.addAttribute("usersList", userService.listAllUsers());
        model.addAttribute("companies", companyService.listAllCompanies());
        return "userForm";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/user/" + user.getId();
    }


}

