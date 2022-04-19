package net.codejava.controller;

import net.codejava.entity.ServiceCenter;
import net.codejava.service.SCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SCController {

    @Autowired
    private SCService service;

    @RequestMapping("/")
    public String viewHomePage(Model model) {
        return "index";
    }

    @RequestMapping("/contacts")
    public String viewContactsPage(Model model) {
        return "contacts";
    }

    @RequestMapping("/showAllRequests")
    public String showAllRequests(Model model) {
        List<ServiceCenter> listServiceCenter = service.listAll();
        model.addAttribute("listServiceCenter", listServiceCenter);

        return "requests";
    }

    @RequestMapping("/showAllRequestz")
    public String showAllRequests() {
        return "requestz";
    }

    @RequestMapping("/new")
    public String showNewServicePage(Model model) {
        ServiceCenter serviceCenter = new ServiceCenter();
        model.addAttribute("serviceCenter", serviceCenter);

        return "new_serviceCenter";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveService(@ModelAttribute("agency") ServiceCenter serviceCenter) {
        if(serviceCenter.getProblem().isEmpty())
            return "redirect:/";
        else
            service.save(serviceCenter);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditAgencyPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_serviceCenter");
        ServiceCenter serviceCenter = service.get(id);
        mav.addObject("serviceCenter", serviceCenter);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteServiceRequest(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}
