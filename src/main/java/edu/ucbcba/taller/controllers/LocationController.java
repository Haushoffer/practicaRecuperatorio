package edu.ucbcba.taller.controllers;

import edu.ucbcba.taller.entities.Location;
import edu.ucbcba.taller.services.LocationService;
import edu.ucbcba.taller.services.TerminalService;
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
public class LocationController {
    private LocationService locationService;
    private TerminalService terminalService;

    @Autowired
    public void setLocationService(LocationService locationService) {
        this.locationService = locationService;
    }
    @Autowired
    public void setTerminalService(TerminalService terminalService) {
        this.terminalService = terminalService;
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("locations", locationService.listAllLocations());
        return "locations";
    }

    @RequestMapping("location/{id}")
    public String showLocation(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        return "locationShow";
    }

    @RequestMapping("location/edit/{id}")
    public String editLocation(@PathVariable Integer id, Model model) {
        model.addAttribute("location", locationService.getLocationById(id));
        model.addAttribute("terminals",terminalService.listAllTerminals());
        return "locationForm";
    }

    @RequestMapping("location/new")
    public String newLocation(Model model) {
        model.addAttribute("location", new Location());
        model.addAttribute("terminals",terminalService.listAllTerminals());
        return "locationForm";
    }

    @RequestMapping(value = "location", method = RequestMethod.POST)
    public String saveLocation(Location location) {
        locationService.saveLocation(location);
        return "redirect:/location/" + location.getId();
    }

    @RequestMapping("location/delete/{id}")
    public String deleteLocation(@PathVariable Integer id) {
        locationService.deleteLocation(id);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/location/like/{id}", method = RequestMethod.GET)
    public String likeLocation(@PathVariable Integer id){
        Location location=locationService.getLocationById(id);
        location.setLikes(location.getLikes()+1);
        locationService.saveLocation(location);
        return "redirect:/location/" + location.getId();
    }

    @RequestMapping(value = "/location/dislike/{id}", method = RequestMethod.GET)
    public String dislikeLocation(@PathVariable Integer id){
        Location location=locationService.getLocationById(id);
        if(location.getLikes()>0) {
            location.setLikes(location.getLikes() - 1);
            locationService.saveLocation(location);
        }
        return "redirect:/location/" + location.getId();
    }
}
