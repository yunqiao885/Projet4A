package com.example.connexion2.controller;

import com.example.connexion2.dao.User;
import com.example.connexion2.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    //private com.example.connexion2.dao.UserRepository UserRepository;
    private UserServiceImpl userServiceImpl;


    //模型视图
    @GetMapping("/index.action")
    public ModelAndView index() {

        return new ModelAndView("index");
    }

    @RequestMapping("/user/register.action")
    public ModelAndView register(User user) {
        userServiceImpl.save(user);
        return new ModelAndView("redirect:/index.action");
    }

    @RequestMapping("/user/login.action")
    public ModelAndView login(User user) {

        //get user's mot de passe and email
        //User loginUser = UserRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        boolean success = userServiceImpl.login(user);
        if(success) {
            return new ModelAndView("welcome");
        }else {
            return new ModelAndView("redirect:/index.action");
        }

    }

    @RequestMapping("/show.action")
    public ModelAndView show(Model model) {

        List<User> userList = userServiceImpl.findAll();
        //把userList放入到模型中
        model.addAttribute("userList",userList);
        return new ModelAndView("show-all-user","userModel",model);
    }

    @RequestMapping("/toEdit/{id}")
    public ModelAndView toEdit(@PathVariable("id")Long id,Model model) {
        //根据ID得到用户
        User user = userServiceImpl.findById(id);
        //将用户放入到model中
        model.addAttribute("user",user);
        return new ModelAndView("edit-user","userModel",model);
    }

    @RequestMapping("/edit.action")
    public ModelAndView Edit(User user) {
        userServiceImpl.save(user);
        return new ModelAndView("redirect:/show.action");
    }
}
