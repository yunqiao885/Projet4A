package com.example.connexion2.controller;

import com.example.connexion2.dao.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {
    @Autowired
    private com.example.connexion2.dao.UserRepository UserRepository;

    //模型视图
    @RequestMapping("/index.action")
    public ModelAndView index() {

        return new ModelAndView("/index.html");
    }

    @RequestMapping("/user/register.action")
    public ModelAndView register(User user) {
        UserRepository.save(user);
        return new ModelAndView("redirect:/index.action");
    }

    @RequestMapping("/user/login.action")
    public ModelAndView login(User user) {

        //获得用户登录名和密码
        User loginUser = UserRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword());
        if(loginUser == null) {
            return new ModelAndView("redirect:/index.action");
        }else {
            return new ModelAndView("/welcome.html");
        }

    }
}
