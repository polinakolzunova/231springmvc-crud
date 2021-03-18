package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class MainController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex(ModelMap model){
        model.addAttribute("users", userService.listUsers());

        return "index";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String getAdd(ModelMap model){
        model.addAttribute("user", new User());
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String postAdd(@ModelAttribute("user") User user){
        userService.add(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String getEdit(@PathVariable("id") long id, ModelMap model){
        model.addAttribute("user", userService.getById(id));

        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public String postEdit(@PathVariable("id") long id, @ModelAttribute("user") User user){
        userService.update(user);

        return "redirect:/";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String getDelete(@ModelAttribute("user") User user){
        userService.remove(user);

        return "redirect:/";
    }

    @GetMapping("/test")
    public String getTest(){
        return "test";
    }

}
