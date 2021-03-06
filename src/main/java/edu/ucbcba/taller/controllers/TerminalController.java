package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Terminal;
import edu.ucbcba.taller.services.CategoryService;
import edu.ucbcba.taller.services.TerminalService;
import edu.ucbcba.taller.services.UserService;
import edu.ucbcba.taller.entities.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
/**
 * Created by coreI7 on 30/04/2017.
 */
@Controller
public class TerminalController {

    private TerminalService terminalService;
    private CategoryService categoryService;
    private UserService userService;


    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }



    @RequestMapping(value = "/terminals", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("terminals", terminalService.listAllTerminals());
        return "terminals";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("terminals", terminalService.listAllTerminals());
        return "index";
    }


    @RequestMapping(value = "/terminal/{id}", method = RequestMethod.GET)
    public String showTerminal(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        return "terminalShow";
    }


    @RequestMapping(value = "/terminal/delete/{id}", method = RequestMethod.GET)
    public String deleteTerminal(@PathVariable Integer id, Model model) {
        terminalService.deleteTerminal(id);
        return "terminals";
    }


    @RequestMapping(value = "/terminal/new", method = RequestMethod.GET)
    public String newTerminal(Model model) {
        model.addAttribute("terminal", new Terminal());
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("users", userService.listAllUsers());
        return "terminalForm";
    }


    @RequestMapping("terminal/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("terminal", terminalService.getTerminalById(id));
        model.addAttribute("categories", categoryService.listAllCategories());
        model.addAttribute("users", userService.listAllUsers());
        return "terminalForm";
    }

    @RequestMapping(value = "terminal", method = RequestMethod.POST)
    public String saveTerminal(Terminal terminal) {
        terminalService.saveTerminal(terminal);
        return "redirect:/terminal/" + terminal.getId();
    }

    @RequestMapping("terminal/map/{id}")
    public String printMap(@PathVariable Integer id, Model model) {
        ArrayList<Double> lats=getAllLats(terminalService.getTerminalById(id).getLocations());
        ArrayList<Double> lngs=getAllLngs(terminalService.getTerminalById(id).getLocations());
        model.addAttribute("lats", lats);
        model.addAttribute("lngs", lngs);
        return "map";
    }

    private ArrayList<Double> getAllLats(Iterable<Location> locations)
    {
        Set<Location> loc=(Set<Location>)locations;
        ArrayList<Double>salida = new ArrayList<Double>();
        for(Location l:loc)
        {
            salida.add(l.getLat().doubleValue());
        }
        return salida;
    }

    private ArrayList<Double> getAllLngs(Iterable<Location> locations)
    {
        Set<Location> loc=(Set<Location>)locations;
        ArrayList<Double>salida = new ArrayList<Double>();
        for(Location l:loc)
        {
            salida.add(l.getLng().doubleValue());
        }
        return salida;
    }
}
