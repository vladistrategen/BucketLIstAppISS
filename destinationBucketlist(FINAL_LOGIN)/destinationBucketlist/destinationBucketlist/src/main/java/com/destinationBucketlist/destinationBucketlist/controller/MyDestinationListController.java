package com.destinationBucketlist.destinationBucketlist.controller;

import com.destinationBucketlist.destinationBucketlist.service.MyDestinationListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDestinationListController {

    @Autowired
    private MyDestinationListService service;

    @RequestMapping("/deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") Long id) {
        service.deleteById(id);
        return "redirect:/my_destinations";
    }
}
