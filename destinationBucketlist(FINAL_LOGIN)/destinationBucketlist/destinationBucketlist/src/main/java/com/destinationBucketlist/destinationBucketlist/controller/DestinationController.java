package com.destinationBucketlist.destinationBucketlist.controller;

import com.destinationBucketlist.destinationBucketlist.entity.Destination;
import com.destinationBucketlist.destinationBucketlist.entity.MyDestinationList;
import com.destinationBucketlist.destinationBucketlist.service.DestinationService;
import com.destinationBucketlist.destinationBucketlist.service.MyDestinationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DestinationController {
    @Autowired
    private DestinationService service;
    @Autowired
    private MyDestinationListService myDestinationService;

    @GetMapping("/")
    public String home() {
        return "login";
    }

    @GetMapping("/admin_home")
    public String loginAdminSubmit() {return "redirect:/adminHome";}

    @GetMapping("/home")
//    public String loginSubmit() {
//        return "/home";
//    }
    public String loginSubmit(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("12345")) {
            // Authentication successful
            System.out.println(username +
                    password);
            return "/adminHome"; // Redirect to a dashboard page
        }
        else if (username.equals("user") && password.equals("12345")) {
            // Authentication successful
            System.out.println(username + password);
            return "/home"; // Redirect to a dashboard page}
            // Authentication failed
        }
        return "redirect:/login?error=true"; // Redirect back to the login page with an error parameter
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {
        if (username.equals("admin") && password.equals("12345")) {
            // Authentication successful
            System.out.println(username +
                    password);
            return "/admin_home"; // Redirect to a dashboard page
        }
        else if (username.equals("user") && password.equals("12345")) {
            // Authentication successful
            System.out.println(username + password);
            return "redirect:/home"; // Redirect to a dashboard page}
            // Authentication failed
        }
        return "redirect:/login?error=true"; // Redirect back to the login page with an error parameter
    }


    @GetMapping("/destination_register")
    public String destinationRegister() {
        return "destinationRegister";
    }

    @GetMapping("/admin_destination_register")
    public String adminDestinationRegister() {
        return "adminDestinationRegister";
    }

    @GetMapping("/available_destinations")
    public ModelAndView getAllDestination() {
        List<Destination> list=service.getAllDestination();
        return new ModelAndView("destinationList","destination",list);
    }

    @GetMapping("/admin_available_destinations")
    public ModelAndView getAllDestinationAdmin() {
        List<Destination> list=service.getAllDestination();
        return new ModelAndView("adminDestinationList","destination",list);
    }

    @PostMapping("/save")
    public String addDestination(@ModelAttribute Destination d) {
        service.save(d);
        return "redirect:/available_destinations";
    }

    @PostMapping("/admin_save")
    public String adminAddDestination (@ModelAttribute Destination d) {
        service.save(d);
        return "redirect:/admin_available_destinations";
    }

    @GetMapping("/my_destinations")
    public String getMyDestinations(Model model)
    {
        List<MyDestinationList>list=myDestinationService.getAllMyDestinations();
        model.addAttribute("destination",list);
        return "myDestinations";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") Long id) {
        Destination d =service.getDestinationById(id);
        MyDestinationList md=new MyDestinationList(d.getId(),d.getGeolocation(),d.getTitle(),d.getDescription(),d.getStartDate(),d.getEndDate());
        myDestinationService.saveMyDestinations(md);
        return "redirect:/my_destinations";
    }

    @RequestMapping("/editDestination/{id}")
    public String editDestination(@PathVariable("id") Long id,Model model) {
        Destination d = service.getDestinationById(id);
        model.addAttribute("destination",d);
        return "destinationEdit";
    }

    @RequestMapping("/adminEditDestination/{id}")
    public String adminEditDestination(@PathVariable("id") Long id, Model model)
    {
        Destination d = service.getDestinationById(id);
        model.addAttribute("destination",d);
        return "adminDestinationEdit";
    }

    @RequestMapping("/deleteDestination/{id}")
    public String deleteDestination(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/available_destinations";
    }

    @RequestMapping("/adminDeleteDestination/{id}")
    public String adminDeleteDestination(@PathVariable("id") Long id)
    {
        service.deleteById(id);
        return "redirect:/admin_available_destinations";
    }

}
